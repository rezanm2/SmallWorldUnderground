package abilities;

import player.Player;

public class Frightened extends Ability
{
	public Frightened()
	{
		amountOfTokens = 4;
		type = "Frightened";
		traitText = "+1 coin for each region that has 3 or more tokens on it.";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
