package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Flocking extends Ability implements CalculatableIncome
{
	TerrainController tc;
	MapTester test;
	Map map;


	public Flocking()
	{
		amountOfTokens = 5;
		name = "Flocking";
		traitText = "+2 coins if all your regions are adjacent.";
	}

	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();

		tc.setAllAdjacentAreas(activePlayer);
		test.whichAreAdjacent();


		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsAdjacent() == false &&
					map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
			{
				System.out.println("A: One of your areas is not adjacent.");
				abilityIncome = 0;
				break;
			}
			else
			{
				abilityIncome = 2;
			}
		}

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return abilityIncome;
	}
}
