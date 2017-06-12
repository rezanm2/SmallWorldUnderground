package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import listCreators.RaceListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Thieving extends Ability implements CalculatableIncome
{
	TerrainController tc;
	MapTester test;
	Map map;
	RaceListCreator raceList;

	public Thieving()
	{
		amountOfTokens = 4;
		name = "Thieving";
		traitText = "Steal 1 coin from each adjacent active race";
	}

	@Override
	public void processAbility(Ammy ammy) {

		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();
		this.raceList = ammy.getRaceList();

		tc.setAllAdjacentAreas(activePlayer);
		test.whichAreAdjacent(activePlayer);



		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsAdjacent() == true &&
					!map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()) &&
					map.getTerrain(terrainCounter).getRace().equals(raceList.getListElement(0)));
			{

			}
		}

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
