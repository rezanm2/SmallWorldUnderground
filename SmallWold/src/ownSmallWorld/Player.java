package ownSmallWorld;

public class Player
{
	public Player(/*Hand hand*/)
	{
		/*this.hand = hand;*/
	};

	int coins = 0;
	/*Set activeSet = new Set("Dwarves");*/
	/*Set passiveSet = new Set("Flames");*/


	public void setCoins(int coins){
		this.coins = coins;
	}

	public int getCoins()
	{
		return coins;
	}
}
