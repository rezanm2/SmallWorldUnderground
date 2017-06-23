package races;

import main.Ammy;
import player.Hand;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author
 */
public class Dwarves extends Race
{
	public Dwarves()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Dwarves";
		traitText = "At end of turn, +1 silver hammer for each mine region.";
	}

	/**
	 * Checked op hoeveel mines het ras staat en kent de silver hammers toe aan de speler.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getRace().getName().equals(this.name)
					&& map.getTerrains().get(x).getTerrainName().equals("Mine"))
			{
				activePlayer.getHand().setSilverHammers(activePlayer.getHand().getSilverHammers() + 1);
			}
		}
	}

}
