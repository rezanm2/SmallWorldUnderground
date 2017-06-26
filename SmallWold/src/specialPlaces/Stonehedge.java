package specialPlaces;


import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
 */
public class Stonehedge extends SpecialPlace
{
	public Stonehedge()
	{
		name = "Stonehedge";
		traitText = "Choose a special power randomly. The race occupying this gains that ability.";
	}

	@Override
	public void processSpecialPlace(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}
}
