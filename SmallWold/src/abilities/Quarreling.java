package abilities;


import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
public class Quarreling extends Ability implements CalculatableIncome
{
	TerrainController tc;
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
	public void processAbility(Player selfPlayer, Map map)
	{
		this.selfPlayer = selfPlayer;
		this.map = map;
		tc.allAdjacentAreas(activePlayer.getActiveSet().getRace());

		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getIsAdjacent() == false &&
					map.getTerrains().get(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
			{

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
