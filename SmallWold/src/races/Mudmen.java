package races;

import main.Ammy;
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
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName()) && map.getTerrains().get(x).getTerrainName().equals("Mud"))
			{
				this.amountOfTokens++;
				System.out.println("Naam Race: " + map.getTerrains().get(x).getRace().getName() + " Naam terrein: " + map.getTerrains().get(x).getTerrainName());
				System.out.println(amountOfTokens);
			}
		}

	}

}
