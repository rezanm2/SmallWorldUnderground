package abilities;

import player.Player;

public class Empty extends Ability
{
	public Empty()
	{
		amountOfTokens = 0;
		type = "Empty";
		traitText = "There is no ability selected.";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}

}
