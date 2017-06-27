package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	private String userName;
	private String activeRace;
	private String activeAbility;
	private String declineRace;
	private String declineAbility;
	private int handTokens;
	private int declineTokens;
	private int balance;


	public Player(String name){
		this.setUserName(name);
		this.balance = 5;

	}
	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUserName() {
		return userName;
	}


	public void setActiveRace(String race) {
		this.activeRace = race;
	}
	public String getActiveRace() {
		return this.activeRace;
	}


	public void setActiveAbility(String ability) {
		this.activeAbility = ability;
	}
	public String getActiveAbility() {
		return this.activeAbility;
	}


	public void setDeclineRace(String declineRace) {
		this.declineRace = declineRace;
	}
	public String getDeclineRace() {
		return this.declineRace;
	}


	public void setDeclineAbility(String declineAbility) {
		this.declineAbility = declineAbility;
	}
	public String getDeclineAbility() {
		return this.declineAbility;
	}


	public void setHandTokens(int handTokens) {
		this.handTokens = handTokens;
	}
	public int getHandTokens() {
		return this.handTokens;
	}


	public void setDeclineTokens(int declineTokens) {
		this.declineTokens = declineTokens;
	}
	public int  getDeclineTokens() {
		return this.declineTokens;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance()
	{
		return this.balance;
	}

}
