package abilities;


import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
public class Flocking extends Ability implements CalculatableIncome
{
	TerrainController tc;
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
	public void processAbility(Player selfPlayer, Map map)
	{
		abilityIncome = 0;
		this.selfPlayer = selfPlayer;
		this.map = map;

		tc.allAdjacentAreas(selfPlayer.getActiveSet().getRace());


		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getIsAdjacent() == false &&
					map.getTerrains().get(terrainCounter).getRace().equals(selfPlayer.getActiveSet().getRace()))
			{

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
