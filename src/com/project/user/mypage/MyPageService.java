package com.project.user.mypage;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

import com.project.auth.AuthDbms;

public class MyPageService {

	public static void memCheck() {
		
		MyPageView.subTitle("내 정보 조회");
		
		String id = "otqapf7199"; // TODO 로그인 연동
		
		for (Member m : MyPageData.memberList) {
			if (m.getId().equals(id)) {
				
				String phoneNum = m.getPhoneNum();
				
				String p1 = phoneNum.substring(0, 3);
				String p2 = phoneNum.substring(3, 7);
				String p3 = phoneNum.substring(7, 11);
				
				phoneNum = p1 + "-" + p2 + "-" + p3;
				
				String birth = m.getBirth();
				
				String b1 = birth.substring(0, 4);
				String b2 = birth.substring(4, 6);
				String b3 = birth.substring(6, 8);
				
				birth = b1 + "-" + b2 + "-" + b3;
				
				System.out.printf("아이디: %s\n\n이름: %s\n\n전화번호: %s\n\n생년월일: %s\n\n할인여부: %s\n\n은행: %s\n\n계좌번호: %s"
									, m.getId()
									, m.getName()
									, phoneNum
									, birth
									, m.getDiscount().equals("1") ? "국가유공자" : 
									  m.getDiscount().equals("2") ? "국민기초생활보장 수급자" :
									  m.getDiscount().equals("3") ? "다자녀가정" : "일반회원"
									, m.getBank()
									, m.getAccountNum());
				break;
			}
		}
		
		MyPageView.pause();
		
	}

	public static void memChange() {
		
		MyPageView.subTitle("내 정보 수정");
		MyPageView.changeList();
		
		String id = "otqapf7199"; // TODO 로그인 연동
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 정보의 번호를 입력해주세요. ");
		
		while (true) {
			int input = scan.nextInt();	
			scan.nextLine();
			
			if (input > 5 || input < 0) {
				System.out.print("잘못된 번호 입니다. 다시 입력해주세요. ");
			} else {
								
				if (input == 0) {
					
				} else if (input == 1) {
					System.out.print("수정할 이름을 입력해주세요. ");
					
					boolean loop = true;
					
					while (loop) {
						String name = scan.nextLine();
						if (name.matches("^[가-힣]{2,12}$"))  {
							
							loop = false;
							for (Member m : MyPageData.memberList) {
								if (m.getId().equals(id)) {
									m.setName(name);
								}
								break;
							}
							
						} else {
							System.out.print("잘못된 이름입니다. 다시 입력해주세요. ");
						}
					}
					
					
					MyPageView.changeComplete();
					
				} else if (input == 2) {
					System.out.print("수정할 전화번호를 입력해주세요. ");
					
					boolean loop = true;
					
					while (loop) {
						String phone = scan.nextLine();		
						
						if (phone.matches("^[0-9]{11}$"))  {
							
							loop = false;
							
							for (Member m : MyPageData.memberList) {
								if (m.getId().equals(id)) {
									m.setPhoneNum(phone);
								}
								break;
							}
							
						} else {
							System.out.print("잘못된 전화번호입니다. 다시 입력해주세요. ");
						}
						
					}
					
					MyPageView.changeComplete();
					
				} else if (input == 3) {
					MyPageView.changeDiscount();
					System.out.print("해당되는 번호를 입력해주세요. ");
					
					boolean loop = true;
					
					while (loop) {
						String discount = scan.nextLine();				
						
						if (discount.matches("[1-4]"))  {
							loop = false;
							for (Member m : MyPageData.memberList) {
								if (m.getId().equals(id)) {
									m.setDiscount(discount);
									break;
								}
							}
							
						} else if (discount.equals("0")) {
							loop = false;
						} else {
							System.out.print("잘못된 번호입니다. 다시 입력해주세요. ");
						}
						
					}
					
					
					
				} else if (input == 4) {
					System.out.print("은행사를 입력해주세요. ");
					String bank = scan.nextLine();
					
					System.out.print("계좌번호를 입력해주세요. ");
					
					boolean loop = true;
					
					while (loop) {
						String accountNum = scan.nextLine();
						accountNum = accountNum.replace("-", "");
						
						if (accountNum.matches("[0-9]+")) {
							for (Member m : MyPageData.memberList) {
								if (m.getId().equals(id)) {
									m.setBank(bank);
									m.setAccountNum(accountNum);
								}
								loop = false;
								break;
							}
						} else {
							System.out.print("잘못된 계좌번호입니다. 다시 입력해주세요. ");
						}
					}
					
					
					MyPageView.changeComplete();
					
				} else if (input == 5) {
					System.out.println("예시) 19990318");
					System.out.print("생년월일을 입력해주세요. ");
					
					boolean loop = true;
					
					while (loop) {
						String birth = scan.nextLine();				
						birth = birth.replace("-", "");
						
						int year = Integer.parseInt(birth.substring(0, 4));
						int month = Integer.parseInt(birth.substring(4, 6));
						int day = Integer.parseInt(birth.substring(6, 8));
						
						
						if (birth.length() == 8
								&& year > 1903
								&& year < 2023
								&& month > 0
								&& month < 13)  {
							
							
							if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
								
								if (month == 2 && day > 29) {
									System.out.println("잘못된 생년월일 입니다.");
								} else {
									loop = false;
									for (Member m : MyPageData.memberList) {
										if (m.getId().equals(id)) {
											m.setBirth(birth);
										}
										break;
									}
								}
							} else {
								
								if (month == 2 && day > 28) {
									System.out.println("잘못된 생년월일 입니다.");
								} else {
									loop = false;
									for (Member m : MyPageData.memberList) {
										if (m.getId().equals(id)) {
											m.setBirth(birth);
										}
										break;
									}
								}
							}
							
						} else {
							System.out.print("잘못된 생년월일입니다. 다시 입력해주세요. ");
						}
					}
					MyPageView.changeComplete();
				}
				MyPageView.pause();
				break;
			}
		}
		
		
		
	}

	public static void classCheck() {
		
		MyPageView.subTitle("수강 내역 조회");
		
		String id = "otqapf7199"; // TODO 로그인 연동
		
		for (Member m : MyPageData.memberList) {
			if (m.getId().equals(id)) {
				for (History h : MyPageData.historyList) {
					if (m.getNo().equals(h.getMemberNum())) {
						for (Course c : MyPageData.courseList) {
							if (h.getCourseNum().equals(c.getCourseNum())) {
								for (Teacher t : MyPageData.teacherList) {
									if (c.getTeacherNum().equals(t.getTeacherNum())) {
										String time = c.getTime();
										String endHour = time.substring(0, 2);
										String endMin  = time.substring(2, 5);
										int hour = Integer.parseInt(endHour) + 1;
										
										String result = hour + endMin;
										
										Calendar nowTime = Calendar.getInstance();
										Calendar courseStartTime = Calendar.getInstance();
										Calendar courseEndTime = Calendar.getInstance();
										
										int year = Integer.parseInt(c.getStartDate().substring(0, 4));
										int month = Integer.parseInt(c.getStartDate().substring(4, 6));
										
										courseStartTime.set(year, month - 1, 1);
										courseEndTime.set(year, month, 1);
										
										long nowTick = nowTime.getTimeInMillis();
										long courseStartTick = courseStartTime.getTimeInMillis();
										long courseEndTick = courseEndTime.getTimeInMillis();
										
										String startEnd = "";
										
										if (nowTick - courseEndTick < 0) {
											startEnd = "수강 전";
										}
										
										if (nowTick > courseStartTick && nowTick < courseEndTick) {
											startEnd = "수강 중";
										}
										
										if (nowTick > courseEndTick) {
											startEnd = "수강 완료";
										}
										
										System.out.printf("강좌명: %s\n"
												+ "강사명: %s\n"
												+ "강의실: %s강의실\n"
												+ "수강인원: %s명\n"
												+ "대상 연령: %s\n"
												+ "수강 시작 여부: %s\n"
												+ "시간: %tF ~ %tF\n     %s %s ~ %s\n"
												, c.getCourseName()
												, t.getTeacherName()
												, c.getRoomNum()
												, c.getNumberOfPeople()
												, c.getTarget()
												, startEnd
												, courseStartTime
												, courseEndTime
												, c.getDayOfWeek()
												, c.getTime()
												, result);
										System.out.println("===========================");
										
									}
									
									
								}
								
							}
						}
					}
					
				}
			}
		}
		
		MyPageView.pause();
		
	}

	public static void classDelete() {
		
		MyPageView.subTitle("수강 신청 취소");
		
		String id = "otqapf7199"; // TODO 로그인 연동
		
		System.out.println("0. 마이페이지");
		System.out.println("===========================");
		
		int num = 0;
		
		for (Member m : MyPageData.memberList) {
			if (m.getId().equals(id)) {
				for (History h : MyPageData.historyList) {
					if (m.getNo().equals(h.getMemberNum())) {
						for (Course c : MyPageData.courseList) {
							if (h.getCourseNum().equals(c.getCourseNum())) {
								
								Calendar nowTime = Calendar.getInstance();
								Calendar courseEndTime = Calendar.getInstance();
										
								int year = Integer.parseInt(c.getStartDate().substring(0, 4));
								int month = Integer.parseInt(c.getStartDate().substring(4, 6));
										
								courseEndTime.set(year, month-1, 1);
										
								long nowTick = nowTime.getTimeInMillis();
								long courseEndTick = courseEndTime.getTimeInMillis();
										
								if (nowTick - courseEndTick < 0) {
									
									num++;
									
									System.out.printf("%d. %s\n",num ,c.getCourseName());
										
									System.out.println("===========================");
								}
							}
						}
					}
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("취소하고 싶은 강좌 번호를 입력하세요: ");
		int deleteSelect = sc.nextInt();

		int num1 = 0;
		num = 0;
		if (deleteSelect == 0) {
		} else {
			for (Member m : MyPageData.memberList) {
			    if (m.getId().equals(id)) {
			    	Iterator<History> history = MyPageData.historyList.iterator();
			    	while (history.hasNext()) {
			    	    History h = history.next();
			    	    num1++;
			    	    if (m.getNo().equals(h.getMemberNum())) {
			    	        for (Course c : MyPageData.courseList) {
			    	            if (h.getCourseNum().equals(c.getCourseNum())) {
			    	                Calendar nowTime = Calendar.getInstance();
			    	                Calendar courseEndTime = Calendar.getInstance();
			    	                
			    	                int year = Integer.parseInt(c.getStartDate().substring(0, 4));
			    	                int month = Integer.parseInt(c.getStartDate().substring(4, 6));
			    	                
			    	                courseEndTime.set(year, month-1, 1);
			    	                
			    	                long nowTick = nowTime.getTimeInMillis();
			    	                long courseEndTick = courseEndTime.getTimeInMillis();
			    	                
			    	                if (nowTick - courseEndTick < 0) {
			    	                    num++;
			    	                    if (num == deleteSelect) {
			    	                    	history.remove();
			    	                        System.out.println();
			    	                        System.out.println("수강신청을 취소하였습니다.");
			    	                        break;
			    	                    }
			    	                }
			    	            }
			    	        }
			    	    }
			    	}
			    }
			}
		}
		MyPageView.pause();
	}
	
	public static void logout() {
		
		// TODO 로그아웃 후 메인 연결
		AuthDbms abc = new AuthDbms();
		abc.selectAuth().clear();
	}
	
	public static void memDelete() {
		
		MyPageView.subTitle("회원 영구 탈퇴");
		
		String id = "otqapf7199"; // TODO 로그인 연동
		
		System.out.println();
		System.out.println("탈퇴한 계정은 절대 복구되지 않습니다.\n"
						 + "정말로 회원을 탈퇴하시겠습니까?\n");
		
		Scanner scan = new Scanner(System.in);
		
		
		boolean loop = true;
		
		while (loop) {

			System.out.print("Y 또는 N 입력: ");
			String answer = scan.nextLine();
			if (answer.equals("Y") || answer.equals("y")) {
				
				Iterator<Member> member = MyPageData.memberList.iterator();
				while (member.hasNext()) {
					Member m = member.next();
					
					if (m.getId().equals(id)) {
						member.remove();
						System.out.println("회원을 탈퇴하였습니다.");
						loop = false;
					}
				}
				
			} else if (answer.equals("N") || answer.equals("n")) {
				loop = false;
				System.out.println("취소하였습니다.");
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}	
		}	
	}
}
