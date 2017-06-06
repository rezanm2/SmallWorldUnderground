package abilities;

import player.Player;

public class Mining extends Ability
{
	public Mining()
	{
		amountOfTokens = 4;
		type = "Mining";
		traitText = "+1 coin for each mine region";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
