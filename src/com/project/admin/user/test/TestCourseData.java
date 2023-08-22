package com.project.admin.user.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.project.course.Course;

public class TestCourseData {
	public static Map<String, Course> map;

	static {
		Map<String, Course> map = new HashMap<>();
		System.out.println(map);

	}

	public static void allCourse() {

		try {
			BufferedReader allReader = new BufferedReader(new FileReader("data\\dataCourse.txt"));
			String line = null;

			try {
				while ((line = allReader.readLine()) != null) {

					String[] temp = line.split(",");

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
							temp[8], temp[9], temp[10], temp[11]);
					
					System.out.println(c.toString());
					
//					map.put(temp[0], c);
//					map.put(temp[0], c);
//					System.out.println(map);

				}
//				System.out.println(map);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
}
