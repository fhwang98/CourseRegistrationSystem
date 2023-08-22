package com.project.auth;

public class Auth {
	
	private String allCode; 
	private String choiceCode;
	private String id; 
	private String name;
	
	
		public String getChoiceCode() {
			return choiceCode;
		}
		public void setChoiceCode(String choiceCode) {
			this.choiceCode = choiceCode;
			
		}
		public String getAllCode() {
			return allCode;
		}
		public void setAllCode(String allCode) {
			this.allCode = allCode;
			
			
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return  allCode + ","+choiceCode+"," + id + ","+ name +"\r\n";
		} 
	
		
	
	
}
