package player;

import java.io.Serializable;

import abilities.Ability;
import models.Set;
import races.Race;

public class Player implements Serializable{
	private boolean hasVengeful;
	private int coins = 0;
	private Set activeSet;
	private Set declineSet;
	private boolean myTurn;
	private String name;


	private Hand hand;

	public Player() {
		this.hand = new Hand();
		this.setMyTurn(false);
	};

	public Player(Set set){ //test constructor
		this.hand = new Hand();
		this.setMyTurn(true);
		this.setActiveSet(set);
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getCoins() {
		return coins;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Set getActiveSet() {
		return activeSet;
	}

	public void setActiveSet(Set activeSet) {
		if(activeSet != null)
		{
			hand.setCurrentTokens(activeSet.getInitialTokens());
		}
		this.activeSet = activeSet;
	}

	public Set getDeclineSet() {
		return declineSet;
	}

	public void setDeclineSet(Set declineSet) {
		this.declineSet = declineSet;
	}

	public void setHasVengeful(boolean hasVengeful) {
		this.hasVengeful = hasVengeful;
	}

	public boolean getHasVengeful() {
		return hasVengeful;
	}

	public boolean isMyTurn() {
		return myTurn;
	}

	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
