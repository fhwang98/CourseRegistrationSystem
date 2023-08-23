package com.project.notice;

import com.project.user.data.DataAdmin;
import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;

public class NoticeService {

	public static void showNoticeList() {

		int index = 0;
		boolean outLoop = true;
		boolean inLoop = true;

		while (outLoop) {

			inLoop = true;
			String sel = null;

			// 공지사항 라벨 출력
			NoticeView.printNoticeLabel();

			for (int i = 0; i < 10; i++) { // 10개씩 출력
				if (index == NoticeData.getList().size()) { // 멈춰야 한다! 다 출력함
					break;
				}

				// 공지사항 객체 가져오기
				Notice n = NoticeData.getList().get(index);

				// 공지사항 제목 출력
				System.out.println(index + ". " + n.getTitle());

				index++;
			}

			// 페이지 이동 안내 라벨 출력
			NoticeView.printMovePage();

			while (inLoop) {

				sel = NoticeMain.scan.nextLine();
				System.out.println();

				if (sel.equals("0")) {
					inLoop = false;
					outLoop = false;

				} else if (sel.equals("1")) {
					if (index == 10) {
						System.out.print("첫번째 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					index = (((index - 1) / 10) - 1) * 10; // 보여줄 일반 회원의 시작 인덱스를 변경
					inLoop = false;

				} else if (sel.equals("2")) {
					if (index == NoticeData.getList().size()) {
						System.out.print("마지막 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					inLoop = false;

				} else if (sel.equals("3")) {
					// 읽을 공지사항 번호 입력받기
					System.out.print("확인할 공지사항 번호를 입력해주세요. : ");
					sel = NoticeMain.scan.nextLine();

					// 적합한 공지사항 인덱스인지 확인
					System.out.println(index + " " + index);
					if (index - 10 <= Integer.parseInt(sel) && Integer.parseInt(sel) <= index - 1) {

					}

					// 적합하다면 해당 공지사항 객체 뽑아오기
					Notice curNotice = NoticeData.getList().get(Integer.parseInt(sel));

					// 공지사항 보여주기
					NoticeService.PrintNoticeData(curNotice);

					inLoop = false;
					index = 0;

				} else {
					System.out.print("잘못된 입력입니다. 다시 입력하세요. : ");
				}
			}

		}

		NoticeView.printLine();
	}

	private static void PrintNoticeData(Notice n) {
		NoticeView.printNoticeLabel();

		System.out.println("제목: " + n.getTitle());
		System.out.println("게시일: " + String.format("%tF-%tT", n.getUploadTime(), n.getUploadTime()));

		String writer = makeWriter(n.getWriter());
		System.out.println("게시자: " + writer); // 관리자 황은하 이런 식으로 출력
		System.out.println("내용: ");
		System.out.println(n.getContent());

		System.out.println("-------------------------------------");
		System.out.println("뒤로 돌아가려면 엔터키를 누르세요.");
		NoticeMain.scan.nextLine();
	}

	private static String makeWriter(String writerCode) {
		String writer = "";

		if (writerCode.charAt(0) == 'T') {
			writer = "강사 ";

			// 강사 리스트에서 강사 이름 찾아오기
			for (DataTeacher t : UserDbms.getTeacherAllList()) {
				if (t.getTeacherCode().equals(writerCode)) {
					writer += t.getName();
					break;
				}
			}

		} else if (writerCode.charAt(0) == 'A') {
			writer = "관리자 ";

			// 관리자 리스트에서 관리자 이름 찾아오기
			for (DataAdmin a : UserDbms.getAdminAllList()) {
				if (a.getAdminCode().equals(writerCode)) {
					writer += a.getName();
					break;
				}
			}
		}

		return writer;
	}

}
