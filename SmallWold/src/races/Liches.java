package races;

import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Jeroen Zandvliet
 */
public class Liches extends Race
{
	public Liches()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Liches";
		traitText = "One coin for each conquered decline token";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}
}
