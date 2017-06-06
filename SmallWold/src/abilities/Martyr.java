package abilities;

import player.Player;

public class Martyr extends Ability
{
	public Martyr()
	{
		amountOfTokens = 5;
		type = "Martyr";
		traitText = "+1 coin every time this race is conquered";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
