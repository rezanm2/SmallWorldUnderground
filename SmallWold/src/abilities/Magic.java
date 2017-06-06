package abilities;

import player.Player;

public class Magic extends Ability
{

	public Magic()
	{
		amountOfTokens = 5;
		type = "Magic";
		traitText = "Copy 1 relic that's currently in play for the entire turn.";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}



}
