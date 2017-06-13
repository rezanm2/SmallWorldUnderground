package player;

import abilities.Ability;
import main.Set;
import races.Race;

public class Player
{
	private boolean hasVengeful;
	private String name;
	private int coins = 0;
	private Set activeSet;
	private Set declineSet;

	private Hand hand;
	public Player(String name)
	{
		this.hand = new Hand();
		this.name = name;
	};

	public void setCoins(int coins){
		this.coins = coins;
	}

	public int getCoins()
	{
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
		hand.setCurrentTokens(activeSet.getInitialTokens());
		this.activeSet = activeSet;
	}

	public Set getDeclineSet() {
		return declineSet;
	}

	public void setDeclineSet(Set declineSet) {
		this.declineSet = declineSet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHasVengeful(boolean hasVengeful)
	{
		this.hasVengeful = hasVengeful;
	}

	public boolean getHasVengeful()
	{
		return hasVengeful;
	}
}
