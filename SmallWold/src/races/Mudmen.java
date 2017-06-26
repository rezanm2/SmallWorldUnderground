package races;

import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Reza Naser
 */
public class Mudmen extends Race
{
	public Mudmen()
	{
		amountOfTokens = 5;
		maxTokens = 12;
		name = "Mudmen";
		traitText = "Get a new mudmen token at the start of Conquest for each mud region.";
	}

	/**
	 * Geeft de speler een aantal tokens terug gelijk aan het aantal mud-terreinen die de speler controleert.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;

		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getRace().getName().equals(selfPlayer.getActiveSet().getRace().getName()) && map.getTerrains().get(x).getTerrainName().equals("Mud"))
			{
				this.amountOfTokens++;
				System.out.println("Naam Race: " + map.getTerrains().get(x).getRace().getName() + " Naam terrein: " + map.getTerrains().get(x).getTerrainName());
				System.out.println(amountOfTokens);
			}
		}

	}

}
