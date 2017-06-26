package races;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse bestaat zodat het ras op leeg gezet kan worden.
 * @author Jeroen Zandvliet
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
	public void processAbility(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}


}
