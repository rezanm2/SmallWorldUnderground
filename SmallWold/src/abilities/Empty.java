package abilities;

import main.Ammy;
import player.Player;
/**
 * Deze klasse bestaat zodat ability op "leeg" gezet kan worden.
 * @author Jeroen Zandvliet
 */
public class Empty extends Ability
{
	public Empty()
	{
		amountOfTokens = 0;
		name = "Empty";
		traitText = "There is no ability selected.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}

}
