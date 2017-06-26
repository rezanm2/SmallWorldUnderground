package races;

import controllers.TerrainController;
import playBoard.Map;
import player.Hand;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Reza Naser
 */
public class Mummies extends Race
{
	TerrainController tc;
	int hand;
	public Mummies()
	{
		amountOfTokens = 10;
		maxTokens = 12;
		name = "Mummies";
		traitText = "It takes 1 extra mummy to conquer a region.";
	}

	/**
	 * Zorgt ervoor dat elk terrein 1 meer kost om  over te nemen.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.map = map;
		this.selfPlayer = selfPlayer;

		//This will be repeated in DeclareCombat class
		if(selfPlayer.getActiveSet().getRace().getName().equals(this.name))
		{
		}
	}

}
