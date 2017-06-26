package races;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Reza Naser
 */
public class Drow extends Race implements CalculatableIncome
{
	TerrainController tc;
	Map map;
	Player activePlayer;
	public Drow()
	{
		amountOfTokens = 4;
		maxTokens = 9;
		name = "Drow";
		traitText = "+1 Coin for each terrain that isn't sharing borders with non-drow.";
	}

	/**
	 * Checked of het ras aangrenzend aan een ander ras ligt.
	 */
	@Override
	public void processAbility(Ammy	ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
		int countTerrains = 0;
		int countRaces = 0;
		tc.setAllAdjacentAreas(activePlayer);


		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getIsAdjacent() == true)
			{
				countTerrains++;
				if(map.getTerrains().get(x).getRace().getName().equals(this.name) ||
						map.getTerrains().get(x).getRace().getName().equals("Empty "))
				{
					countRaces++;
				}

			}


		}
		if(countTerrains == countRaces)
		{
			raceIncome++;
			System.out.println("1 bonus coin recieved");
		}
		countTerrains = 0;
		countRaces = 0;

	}

	@Override
	public int getRaceIncome()
	{
		return raceIncome;
	}
}
