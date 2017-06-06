package abilities;

import player.Player;

public class Muddy extends Ability
{
	public Muddy()
	{
		amountOfTokens = 3;
		type = "Flocking";
		traitText = "+1 coin for each mud region";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
