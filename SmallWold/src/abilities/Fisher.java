package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
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

	/**
	 * Checked welke gebieden de speler controleert die aangrezend zijn aan de rivier, en verhoogd de extra inkomsten.
	 */
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

		for(terrainCounter = 0; terrainCounter<map.getTerrains().size(); terrainCounter++)
		{
			if(map.getTerrains().get(terrainCounter).getIsAdjacent() == true
					&& map.getTerrains().get(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
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
