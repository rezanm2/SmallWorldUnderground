package abilities;

import java.util.List;

import controllers.TerrainController;
import listCreators.AbilityListCreator;
import listCreators.SpecialPlaceListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Adventurous extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;
	Map map;
	SpecialPlaceListCreator specialPlaceList;

	public Adventurous()
	{
		amountOfTokens = 5;
		name = "Adventurous";
		traitText = "+1 coin for each popular place";
	}

	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
		this.specialPlaceList = ammy.getSpecialPlaceList();
		abilityIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()) &&
					!map.getTerrain(terrainCounter).getSpecialPlace().equals(specialPlaceList.getListElement(0)))
			{
				abilityIncome++;
			}
		}
	}

	@Override
	public int getAbilityIncome() {
		return abilityIncome;
	}
}
