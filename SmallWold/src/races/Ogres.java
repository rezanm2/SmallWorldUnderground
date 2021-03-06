package races;


import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Reza Naser
 */
public class Ogres extends Race
{
	public Ogres()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Ogres";
		traitText = "It takes one less token to conquer a region (minimum of one)";
	}

	/**
	 * Zorgt ervoor dat elk terrein 1 minder kost om over te nemen.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {

		this.map = map;
		this.selfPlayer = selfPlayer;
	}

}
