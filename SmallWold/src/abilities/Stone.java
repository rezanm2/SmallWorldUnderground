package abilities;

import player.Player;

public class Stone extends Ability
{
	public Stone()
	{
		amountOfTokens = 4;
		type = "Stone";
		traitText = "+1 coin for each Stone region";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
