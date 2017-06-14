package abilities;

import java.util.ArrayList;

import controllers.MapTester;
import controllers.TerrainController;
import controllers.TokenController;
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
	TokenController tokenController;
	private int abilityIncome;
	private ArrayList<String> stolenRaces = new ArrayList<String>();
	private boolean doThief;

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
		this.tokenController = ammy.getToc();

		tc.setAllAdjacentAreas(activePlayer);
		test.whichAreAdjacent();

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsAdjacent() == true &&
			   map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()) &&
			   map.getTerrain(terrainCounter).getRace().equals(raceList.getListElement(0)))
				{
				
				for(int i = 0; i < stolenRaces.size(); i++)
				{
					if(stolenRaces.get(i).equals(map.getTerrain(terrainCounter).getRace().getName()))
					{
						doThief = false;
					}
				}
				
				if(doThief = true)
					{
					stolenRaces.add(map.getTerrain(terrainCounter).getRace().getName());
					System.out.println("Stole 1 coin from " + map.getTerrain(terrainCounter).getRace().getName());
					tokenController.linkRaceToPlayer(map.getTerrain(terrainCounter).getRace());
					tokenController.getRacesPlayer().setCoins(tokenController.getRacesPlayer().getCoins() - 1);
					abilityIncome++;
				}
			}
			doThief = true;
		}
}
	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}

	@Override
	public int getAbilityIncome() {
		return abilityIncome;
	}
}
