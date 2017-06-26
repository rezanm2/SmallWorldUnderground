package races;


import playBoard.Map;
import player.Player;

/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Jeroen Zandvliet
 */

public class Gnomes extends Race
{
	public Gnomes()
	{
		amountOfTokens = 6;
		maxTokens = 11;
		name = "Gnomes";
		traitText = "Can't be targeted by any effects";
	}

	@Override
	public void processAbility(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}

}
