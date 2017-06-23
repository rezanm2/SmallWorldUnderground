package abilities;

import java.util.List;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
public class Adventurous extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;
	Map map;

	public Adventurous()
	{
		amountOfTokens = 5;
		name = "Adventurous";
		traitText = "+1 coin for each popular place";
	}

	/**
	 * Zorgt ervoor dat als de speler special places controleert, de extra inkomsten verhoogd worden.
	 */
	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
		abilityIncome = 0;

//		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
//		{
//			if(activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()) &&
//					!map.getTerrain(terrainCounter).getSpecialPlace().equals(specialPlaceList.getListElement(0)))
//			{
//				abilityIncome++;
//			}
//		}
	}

	@Override
	public int getAbilityIncome() {
		return abilityIncome;
	}
}
