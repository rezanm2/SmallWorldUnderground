package abilities;

import player.Player;

public class Fisher extends Ability
{
	public Fisher()
	{
		amountOfTokens = 4;
		type = "Fisher";
		traitText = "+1 coin for every coastal region";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
