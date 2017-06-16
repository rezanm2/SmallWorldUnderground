package data;

import java.util.ArrayList;

public class Player {
	private String userName;
	private String activeRace;
	private String activeAbility;
	private String declineRace;
	private String declineAbility;
	private int balance;


	public Player(String name){
		this.setUserName(name);
		this.balance = 5;

	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}
