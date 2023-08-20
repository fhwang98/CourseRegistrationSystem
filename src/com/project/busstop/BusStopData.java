package com.project.busstop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BusStopData {
	public final static String KEY = "CyGDxLq3m558%2BnuTh5ZIGVs1ZsV%2FJYNhvoIKPq4gnApUrtPtRi8tUaWziDwY%2BCrYVF%2BimSzN7lTocuLE0kVDzQ%3D%3D";

	public static ArrayList<BusStop> busStopList;

	static {
		BusStopData.busStopList = new ArrayList<>();
	}

	// 버스정류장 데이터를 open api를 이용하여 가져온 후 list에 저장
	public static void load() {

		// 1. 요청 URL 만들기
		String url = "https://api.odcloud.kr/api/3072646/v1/uddi:e1b5b0b2-b00a-4834-bf9d-c35438b80982?page=1&perPage=75&returnType=json&serviceKey="
				+ KEY;

		// URL 객체 생성
		try {
			// URL 객체 생성
			URL obj_url = new URL(url);

			// URL과 연결하는 객체 생성 > 브라우저 대신 접속
			HttpURLConnection conn = (HttpURLConnection) obj_url.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			BufferedReader reader = null;

			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			// reader로 검색 결과 읽기
			JSONParser parser = new JSONParser();
			JSONObject root = (JSONObject) parser.parse(reader);
			JSONArray dataArr = (JSONArray) root.get("data");

			// 객체를 하나씩 읽어서 BusStop 객체로 변환하기
			for (Object obj : dataArr) {
				JSONObject busStopJSonObj = (JSONObject) obj;

				String bName = busStopJSonObj.get("정 류 장").toString();
				String bNum = busStopJSonObj.get("연번").toString();

				// null인 경우는 toString()이 안된다. -> toStrin() 하기 전에 null인지 값 확인을 먼저 해야 한다.
				String bTime1 = timeValueToString(busStopJSonObj.get("1회"));
				String bTime2 = timeValueToString(busStopJSonObj.get("2회"));
				String bTime3 = timeValueToString(busStopJSonObj.get("3회"));
				String bTime4 = timeValueToString(busStopJSonObj.get("4회"));
				String bTime5 = timeValueToString(busStopJSonObj.get("5회"));

				// 가져온 데이터로 BusStop 객체 만들기
				BusStop busStop = new BusStop(bName, bNum, bTime1, bTime2, bTime3, bTime4, bTime5);

				// busStopList에 생성된 busStop 객체를 넣기
				BusStopData.busStopList.add(busStop);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		// 확인용 출력
//		System.out.println(BusStopData.busStopList);
	}

	// 가져온 값이 null이면 null을 반환하고, null이 아닌 값이 들어있다면 문자열로 형변환하여 반환한다.
	private static String timeValueToString(Object data) {
		if (data == null) {
			return null;
		} else {
			return data.toString();
		}
	}
}
