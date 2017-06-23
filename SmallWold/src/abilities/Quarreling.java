package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Quarreling extends Ability implements CalculatableIncome
{
	TerrainController tc;
	MapTester test;
	Map map;
	Player activePlayer;
	public Quarreling()
	{
		amountOfTokens = 3;
		name = "Quarreling";
		traitText = "+1 coin for each seperate region";
	}

	/**
	 * Checked of de terreinen van de speler niet aangrenzend zijn en verhoogd de extra inkomsten.
	 */
	@Override
	public void processAbility(Ammy ammy)
	{
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
				abilityIncome += 1;
				break;
			}
			else
			{
				abilityIncome = 0;
			}
		}
	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
