package com.project.admin.user.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class UserData {
	public static ArrayList<User> userList;

	static {
		UserData.userList = new ArrayList<>();
	}

	public static void loadUserData() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("file\\dataMember.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				String userNum = temp[0];
				String id = temp[1];
				String pw = temp[2];
				String name = temp[3];
				String phone = temp[4];
				String bday = temp[5];
				int discountNum = Integer.parseInt(temp[6]);
				String bank = temp[7];
				String accountNum = temp[8];
				int withdrawn = Integer.parseInt(temp[9]);

				User u = new User(userNum, id, pw, name, phone, bday, discountNum, bank, accountNum, withdrawn);

//				System.out.println(u.toString());
				UserData.userList.add(u);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
