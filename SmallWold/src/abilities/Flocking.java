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

	/**
	 * Checked of alle terreinen die de speler heeft aangrenzen zijn en verhoogd de extra inkomsten.
	 */
	@Override
	public void processAbility(Ammy ammy)
	{
		abilityIncome = 0;
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();

		tc.setAllAdjacentAreas(activePlayer);
		test.whichAreAdjacent();


		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getIsAdjacent() == false &&
					map.getTerrains().get(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
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
