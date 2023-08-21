package com.project.user.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDbms {
	private final static String CRLF = "\r\n";
	private final static String dataMemberPath = "data\\dataMember.txt";
	private final static String dataTeacherPath = "data\\dataTeacher.txt";
	private final static String dataAdminPath = "data\\dataAdmin.txt";

	private static ArrayList<DataMember> memberAllList;
	private static ArrayList<DataTeacher> teacherAllList;
	private static ArrayList<DataAdmin> adminAllList;

	private static String maxMemberCode = "N000";
	private static String maxTeacherCode = "T000";
	private static String maxAdminCode = "A000";

	static { // static 생성자 추가
		memberAllList = new ArrayList<DataMember>();
		teacherAllList = new ArrayList<DataTeacher>();
		adminAllList = new ArrayList<DataAdmin>();
	}

	public UserDbms() {
		readMemberData();
		readTeacherData();
		readAdminData();
	}

	// list getter 추가
	public static ArrayList<DataMember> getMemberAllList() {
		return memberAllList;
	}

	public static ArrayList<DataTeacher> getTeacherAllList() {
		return teacherAllList;
	}

	public static ArrayList<DataAdmin> getAdminAllList() {
		return adminAllList;
	}

	// 패스워드 변경
	public static void setModifyPw(HashMap<String, String> pwInfo) {
		String code = pwInfo.get("code");
		String chPw = pwInfo.get("chPw");
		File file = null;
		StringBuffer strBff = new StringBuffer();

		if ("N".equals(code.substring(0, 1))) {
			file = new File(dataMemberPath);
		} else if ("T".equals(code.substring(0, 1))) {
			file = new File(dataTeacherPath);
		} else if ("A".equals(code.substring(0, 1))) {
			file = new File(dataAdminPath);
		} else {
			return;
		}

		if (file != null) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));

				String line = null;
				while ((line = br.readLine()) != null) {
					String[] lineSplit = line.split(",");

					if ("N".equals(code.substring(0, 1))) {
						DataMember m = new DataMember(lineSplit);
						if (m.getMemberCode().equals(code)) {
							m.setPassword(chPw);
							strBff.append(m.toString());
						} else {
							strBff.append(line);
						}

					} else if ("T".equals(code.substring(0, 1))) {
						DataTeacher t = new DataTeacher(lineSplit);
						if (t.getTeacherCode().equals(code)) {
							t.setPassword(chPw);
							strBff.append(t.toString());
						} else {
							strBff.append(line);
						}
					} else if ("A".equals(code.substring(0, 1))) {
						DataAdmin a = new DataAdmin(lineSplit);
						if (a.getAdminCode().equals(code)) {
							a.setPassword(chPw);
							strBff.append(a.toString());
						} else {
							strBff.append(line);
						}

					}

					strBff.append(CRLF);
				}

				FileWriter fw = new FileWriter(file.getPath());
				fw.write(strBff.toString());

				fw.close();
				br.close();
			} catch (Exception e) {
				System.out.println("Exception:" + e.getMessage());
			}
		}
	}

	// 새로운 비밀번호가 기존 비밀번호와 같은지 체크하는 전체 회원 리스트 생성
	public static HashMap<String, String> getPwFind(String name, String tel) {
		readMemberData();
		readTeacherData();
		readAdminData();

		HashMap<String, String> pwMap = new HashMap<String, String>();

		// 고유 코드로 누구의 pw인지 확인 가능
		for (int i = 0; i < memberAllList.size(); i++) {
			String temp = memberAllList.get(i).getTel().replaceAll("-", "");
			if (memberAllList.get(i).getName().equals(name) && temp.equals(tel)) {
				pwMap.put("code", memberAllList.get(i).getMemberCode());
				pwMap.put("password", memberAllList.get(i).getPassword());
			}
		}

		for (int i = 0; i < teacherAllList.size(); i++) {
			String temp = teacherAllList.get(i).getTel().replaceAll("-", "");
			if (teacherAllList.get(i).getName().equals(name) && temp.equals(tel)) {
				pwMap.put("code", teacherAllList.get(i).getTeacherCode());
				pwMap.put("password", teacherAllList.get(i).getPassword());
			}
		}

		for (int i = 0; i < adminAllList.size(); i++) {
			String temp = adminAllList.get(i).getTel().replaceAll("-", "");
			if (adminAllList.get(i).getName().equals(name) && temp.equals(tel)) {
				pwMap.put("code", adminAllList.get(i).getAdminCode());
				pwMap.put("password", adminAllList.get(i).getPassword());
			}
		}
		return pwMap;
	}

	// 아이디 찾는 전체 회원 리스트 생성
	public static ArrayList<String> getIdFind(String name, String birth) {
		readMemberData();
		readTeacherData();
		readAdminData();

		ArrayList<String> idList = new ArrayList<String>();
		for (int i = 0; i < memberAllList.size(); i++) {
			if (memberAllList.get(i).getName().equals(name) && memberAllList.get(i).getBirth().equals(birth)) {
				idList.add(memberAllList.get(i).getId());
			}
		}
		for (int i = 0; i < teacherAllList.size(); i++) {
			if (teacherAllList.get(i).getName().equals(name) && teacherAllList.get(i).getBirth().equals(birth)) {
				idList.add(teacherAllList.get(i).getId());
			}
		}

		for (int i = 0; i < adminAllList.size(); i++) {
			if (adminAllList.get(i).getName().equals(name) && adminAllList.get(i).getBirth().equals(birth)) {
				idList.add(adminAllList.get(i).getId());
			}
		}
		return idList;
	}

	// 일반회원 정보찾기
	// 회원찾기 이름, 비밀번호
	public static DataMember searchMemberByIdPw(String id, String pw) {

		if (id == null || "".equals(id)) {
			System.out.println("id 값은 필수 입니다.");
			return null;
		} else if (pw == null || "".equals(pw)) {
			System.out.println("pw 값은 필수 입니다.");
			return null;
		}

		if (memberAllList.size() == 0) {
			readMemberData();
		}

		for (int i = 0; i < memberAllList.size(); i++) {
			if (memberAllList.get(i).getId().equals(id) && memberAllList.get(i).getPassword().equals(pw)) {
				return memberAllList.get(i);
			}
		}
		return null;

	}

	// 회원찾기 이름, 생년월일
	public static DataMember searchMemberByNameBirt(String name, String birth) {

		if (name == null || "".equals(name)) {
			System.out.println("name 값은 필수 입니다.");
			return null;
		} else if (birth == null || "".equals(birth)) {
			System.out.println("birth 값은 필수 입니다.");
			return null;
		}

		if (memberAllList.size() == 0) {
			readMemberData();
		}

		for (int i = 0; i < memberAllList.size(); i++) {
			if (memberAllList.get(i).getName().equals(name) && memberAllList.get(i).getBirth().equals(birth)) {
				return memberAllList.get(i);
			}
		}
		return null;

	}

	// 회원찾기 이름으로
	public static DataMember searchMemberByName(String name) {

		if (name == null || "".equals(name)) {
			System.out.println("name 값은 필수 입니다.");
			return null;
		}

		if (memberAllList.size() == 0) {
			readMemberData();
		}

		for (int i = 0; i < memberAllList.size(); i++) {
			if (memberAllList.get(i).getName().equals(name)) {
				return memberAllList.get(i);
			}
		}
		return null;
	}

	// 회원찾기 아이디로
	public static DataMember searchMemberById(String id) {
		if (id == null || "".equals(id)) {
			System.out.println("id 값은 필수 입니다.");
			return null;
		}

		if (memberAllList.size() == 0) {
			readMemberData();
		}

		for (int i = 0; i < memberAllList.size(); i++) {
			if (memberAllList.get(i).getId().equals(id)) {

				return memberAllList.get(i);
			}
		}

		return null;

	}

	// 강사찾기
	// 회원찾기 이름, 비밀번호
	public static DataTeacher searchTeacherByIdPw(String id, String pw) {

		if (id == null || "".equals(id)) {
			System.out.println("id 값은 필수 입니다.");
			return null;
		} else if (pw == null || "".equals(pw)) {
			System.out.println("pw 값은 필수 입니다.");
			return null;
		}

		if (teacherAllList.size() == 0) {
			readTeacherData();
		}

		for (int i = 0; i < teacherAllList.size(); i++) {
			if (teacherAllList.get(i).getId().equals(id) && teacherAllList.get(i).getPassword().equals(pw)) {
				return teacherAllList.get(i);
			}
		}
		return null;

	}

	// 회원찾기 이름, 생년월일
	public static DataTeacher searchTeacherByNameBirt(String name, String birth) {

		if (name == null || "".equals(name)) {
			System.out.println("name 값은 필수 입니다.");
			return null;
		} else if (birth == null || "".equals(birth)) {
			System.out.println("birth 값은 필수 입니다.");
			return null;
		}

		if (teacherAllList.size() == 0) {
			readTeacherData();
		}

		for (int i = 0; i < teacherAllList.size(); i++) {
			if (teacherAllList.get(i).getName().equals(name) && teacherAllList.get(i).getBirth().equals(birth)) {
				return teacherAllList.get(i);
			}
		}
		return null;

	}

	// 회원찾기 이름으로
	public static DataTeacher searchTeacherByName(String name) {

		if (name == null || "".equals(name)) {
			System.out.println("name 값은 필수 입니다.");
			return null;
		}

		if (teacherAllList.size() == 0) {
			readTeacherData();
		}

		for (int i = 0; i < teacherAllList.size(); i++) {
			if (teacherAllList.get(i).getName().equals(name)) {
				return teacherAllList.get(i);
			}
		}
		return null;
	}

	// 회원찾기 아이디로
	public static DataTeacher searchTeacherById(String id) {
		if (id == null || "".equals(id)) {
			System.out.println("id 값은 필수 입니다.");
			return null;
		}

		if (teacherAllList.size() == 0) {
			readTeacherData();
		}

		for (int i = 0; i < teacherAllList.size(); i++) {
			if (teacherAllList.get(i).getId().equals(id)) {

				return teacherAllList.get(i);
			}
		}

		return null;

	}

	// 관리자 정보찾기

	// 회원찾기 이름, 비밀번호
	public static DataAdmin searchAdminByIdPw(String id, String pw) {

		if (id == null || "".equals(id)) {
			System.out.println("id 값은 필수 입니다.");
			return null;
		} else if (pw == null || "".equals(pw)) {
			System.out.println("pw 값은 필수 입니다.");
			return null;
		}

		if (adminAllList.size() == 0) {
			readAdminData();
		}

		for (int i = 0; i < adminAllList.size(); i++) {
			if (adminAllList.get(i).getId().equals(id) && adminAllList.get(i).getPassword().equals(pw)) {
				return adminAllList.get(i);
			}
		}
		return null;

	}

	// 회원찾기 이름, 생년월일
	public static DataAdmin searchAdminByNameBirt(String name, String birth) {

		if (name == null || "".equals(name)) {
			System.out.println("name 값은 필수 입니다.");
			return null;
		} else if (birth == null || "".equals(birth)) {
			System.out.println("birth 값은 필수 입니다.");
			return null;
		}

		if (adminAllList.size() == 0) {
			readAdminData();
		}

		for (int i = 0; i < adminAllList.size(); i++) {
			if (adminAllList.get(i).getName().equals(name) && adminAllList.get(i).getBirth().equals(birth)) {
				return adminAllList.get(i);
			}
		}
		return null;

	}

	// 회원찾기 이름으로
	public static DataAdmin searchAdminByName(String name) {

		if (name == null || "".equals(name)) {
			System.out.println("name 값은 필수 입니다.");
			return null;
		}

		if (adminAllList.size() == 0) {
			readAdminData();
		}

		for (int i = 0; i < adminAllList.size(); i++) {
			if (adminAllList.get(i).getName().equals(name)) {
				return adminAllList.get(i);
			}
		}
		return null;
	}

	// 회원찾기 아이디로
	public static DataAdmin searchAdminById(String id) {
		if (id == null || "".equals(id)) {
			System.out.println("id 값은 필수 입니다.");
			return null;
		}

		if (adminAllList.size() == 0) {
			readAdminData();
		}

		for (int i = 0; i < adminAllList.size(); i++) {
			if (adminAllList.get(i).getId().equals(id)) {

				return adminAllList.get(i);
			}
		}

		return null;

	}

	private static void readMemberData() {
		File f = new File(dataMemberPath);
		if (f.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(f.getPath()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] memeberLine = line.split(",");
					DataMember m = new DataMember();
					m.setDataMemeber(memeberLine);
					memberAllList.add(m);
					if (Integer.parseInt(m.getMemberCode().substring(1)) >= Integer
							.parseInt(maxMemberCode.substring(1))) {
						maxMemberCode = "N"
								+ String.format("%03d", (Integer.parseInt(m.getMemberCode().substring(1)) + 1));
					}

				}
				reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	private static void readTeacherData() {
		File f = new File(dataTeacherPath);
		if (f.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(f.getPath()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] teacherLine = line.split(",");
					DataTeacher t = new DataTeacher();
					t.setDataTeacher(teacherLine);
					teacherAllList.add(t);
					if (Integer.parseInt(t.getTeacherCode().substring(1)) >= Integer
							.parseInt(maxTeacherCode.substring(1))) {
						maxTeacherCode = "T"
								+ String.format("%03d", (Integer.parseInt(t.getTeacherCode().substring(1)) + 1));

					}
				}
				reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	private static void readAdminData() {
		File f = new File(dataAdminPath);
		if (f.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(f.getPath()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] adminLine = line.split(",");
					DataAdmin a = new DataAdmin();
					a.setDataAdmin(adminLine);
					adminAllList.add(a);
					if (Integer.parseInt(a.getAdminCode().substring(1)) >= Integer
							.parseInt(maxAdminCode.substring(1))) {
						maxAdminCode = "A"
								+ String.format("%03d", (Integer.parseInt(a.getAdminCode().substring(1)) + 1));

					}
				}
				reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	public static void setMemeber(DataMember m) {
		File f = new File(dataMemberPath);
		readMemberData();
		if (f.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(f.getPath(), true));
				writer.newLine();
				m.setMemberCode(maxMemberCode);
				writer.write(m.toString());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	public static void setTeacher(DataTeacher t) {
		File f = new File(dataTeacherPath);
		readTeacherData();
		if (f.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(f.getPath(), true));
				writer.newLine();
				t.setTeacherCode(maxTeacherCode);
				writer.write(t.toString());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	public static void setAdmin(DataAdmin a) {
		File f = new File(dataAdminPath);
		readAdminData();
		if (f.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(f.getPath(), true));
				writer.newLine();
				a.setAdminCode(maxAdminCode);
				writer.write(a.toString());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

}
