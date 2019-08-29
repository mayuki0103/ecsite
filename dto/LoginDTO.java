package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
//	↑取得するデータ

	public String getLoginId(){
		return loginId;
	}
//	↑フィールドの値を取得するメソッド
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}
//	↑フィールドに設定するメソッド
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}

}
