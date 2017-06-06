package abilities;

import player.Player;

public class Flocking extends Ability
{
	public Flocking()
	{
		amountOfTokens = 5;
		type = "Flocking";
		traitText = "+2 coins if all your regions are adjacent.";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
