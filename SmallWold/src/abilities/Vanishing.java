package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import listCreators.RaceListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
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

	/**
	 * Verwijdert alle decline tokens van de speler en verhoogd de extra inkomen.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();

		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			abilityIncome += 2;
			map.getTerrains().get(terrainCounter).setRace(raceList.getListElement(0));
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
