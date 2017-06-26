package races;


import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Jeroen Zandvliet
 */
public class Lizardmen extends Race
{
	public Lizardmen()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Lizardmen";
		traitText = "Pass through any river without conquering when they're empty";
	}

	@Override
	public void processAbility(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}
}
