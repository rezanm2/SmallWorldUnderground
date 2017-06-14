package abilities;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Fisher extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int terrainCounter;
	Map map;

	public Fisher()
	{
		amountOfTokens = 4;
		name = "Fisher";
		traitText = "+1 coin for every pair of coastal regions";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.tc = ammy.getTc();
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();


		tc.checkAdjacentToTerrainType("River");

		for(terrainCounter = 0; terrainCounter<map.getAllTerrains().size(); terrainCounter++)
		{
			if(map.getTerrain(terrainCounter).getIsAdjacent() == true
					&& map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
			{
				abilityIncome += 0.5;

			}

			abilityIncome -= abilityIncome % 1000;
			System.out.println("A: Income: " + abilityIncome);
		}

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
