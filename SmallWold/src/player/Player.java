package player;

import abilities.Ability;
import main.Set;
import races.Race;

public class Player
{
	Hand hand;

	public Player(Hand hand)
	{
		this.hand = hand;
	};

	int coins = 0;
	Set activeSet;
	Set passiveSet;

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
		this.activeSet = activeSet;
	}

	public Set getPassiveSet() {
		return passiveSet;
	}

	public void setPassiveSet(Set passiveSet) {
		this.passiveSet = passiveSet;
	}

}
