package races;

import main.Ammy;
import player.Player;
/**
 * Deze klasse bestaat zodat het ras op leeg gezet kan worden.
 * @author
 */
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
