package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import listCreators.RaceListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Vanishing extends Ability implements CalculatableIncome
{
	TerrainController tc;
	MapTester test;
	Map map;
	private int abilityIncome;
	private int terrainCounter;
	RaceListCreator raceList;

	public Vanishing()
	{
		amountOfTokens = 5;
		name = "Vanishing";
		traitText = "Remove all tokens when going in decline and get 2 coins for each region";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			abilityIncome += 2;
			map.getTerrain(terrainCounter).setRace(raceList.getListElement(0));
		}
	}

	@Override
	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
