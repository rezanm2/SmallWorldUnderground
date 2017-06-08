package abilities;

import main.Ammy;
import player.Player;

public class Empty extends Ability
{
	public Empty()
	{
		amountOfTokens = 0;
		name = "Empty";
		traitText = "There is no ability selected.";
	}

	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}

}
