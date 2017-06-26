package specialPlaces;

import playBoard.Map;
import player.Player;

/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Jeroen Zandvliet
 */
public class AltarOfSouls extends SpecialPlace
{
	public AltarOfSouls()
	{
		name = "Altar of Souls";
		traitText = "Discard a single in decline token for 3 coins at turn's end";
	}

	@Override
	public void processSpecialPlace(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}
}
