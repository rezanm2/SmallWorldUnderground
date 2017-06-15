package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Fisher extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int terrainCounter;
	private double tempAbilityIncome;
	Map map;
	MapTester test;

	public Fisher()
	{
		amountOfTokens = 4;
		name = "Fisher";
		traitText = "+1 coin for every pair of coastal regions";
	}

	@Override
	public void processAbility(Ammy ammy) {
		abilityIncome = 0;
		this.tc = ammy.getTc();
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		this.test = ammy.getTest();

		tc.setNotAdjacent();
		tc.checkAdjacentToTerrainType("River");

		test.whichAreAdjacent();

		for(terrainCounter = 0; terrainCounter<map.getAllTerrains().size(); terrainCounter++)
		{
			if(map.getTerrain(terrainCounter).getIsAdjacent() == true
					&& map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
			{
				tempAbilityIncome += 0.5;
			}
			abilityIncome = (int)Math.floor(tempAbilityIncome);
		}

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return abilityIncome;
	}
}
