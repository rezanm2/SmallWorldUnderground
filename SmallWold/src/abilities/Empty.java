package abilities;

import main.Ammy;
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
	public void calculateAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}

}
