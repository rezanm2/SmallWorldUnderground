package races;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Drow extends Race implements CalculatableIncome
{
	TerrainController tc;
	MapTester test;
	Map map;
	Player activePlayer;
	public Drow()
	{
		amountOfTokens = 4;
		maxTokens = 9;
		name = "Drow";
		traitText = "+1 Coin for each terrain that isn't sharing borders with non-drow.";
	}

	@Override
	public void processAbility(Ammy	ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();
		int countTerrains = 0;
		int countRaces = 0;
		tc.setAllAdjacentAreas(activePlayer);
		test.whichAreAdjacent();


		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(map.getTerrain(x).getIsAdjacent() == true)
			{
				countTerrains++;
				if(map.getTerrain(x).getRace().getName().equals(this.name) ||
						map.getTerrain(x).getRace().getName().equals("Empty "))
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
	}

	@Override
	public int getRaceIncome()
	{
		return raceIncome;
	}
}
