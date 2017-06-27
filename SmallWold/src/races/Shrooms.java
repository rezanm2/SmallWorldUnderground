package races;

import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Reza Naser
 */
public class Shrooms extends Race implements CalculatableIncome
{
	public Shrooms()
	{
		amountOfTokens = 4;
		maxTokens = 10;
		name = "Shrooms";
		traitText = "+1 coin for each Shroom region";
	}

	/**
	 * Checked hoeveel shroomterreinen de speler controleert en berekent de extra inkomsten daarvan.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;


		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getTerrainName().equals(map.getTerrains().get(x).getRace().getName()) && selfPlayer.getActiveSet().getRace().getName().equals(this.name))
			{
				raceIncome++;
				System.out.println("Naam terrein: " + map.getTerrains().get(x).getTerrainName() + " Naam Race: " + map.getTerrains().get(x).getRace().getName());

				System.out.println("+1 bonus coin received.");
			}
		}

	}


	public int getRaceIncome() {
		return raceIncome;
	}
}
