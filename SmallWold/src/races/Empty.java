package races;

import main.Ammy;
import player.Player;

public class Empty extends Race
{

	public Empty()
	{
		amountOfTokens = 0;
		maxTokens = 0;
		name = "Empty";
		traitText = "There is no race selected.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}


}
