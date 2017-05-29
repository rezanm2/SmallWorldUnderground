package player;

import ownSmallWorld.Set;

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
}
