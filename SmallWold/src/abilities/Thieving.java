package abilities;

import java.util.ArrayList;
import controllers.TerrainController;
import controllers.TokenController;
import listCreators.RaceListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Thieving extends Ability implements CalculatableIncome
{
	TerrainController tc;
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
	/**
	 * Checked welke actieve rassen naast het ras zitten, en steel 1 coin per actief ras.
	 */

	@Override
	public void processAbility(Ammy ammy) {

		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
		this.raceList = ammy.getRaceList();
		this.tokenController = ammy.getToc();

		tc.setAllAdjacentAreas(activePlayer);

		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getIsAdjacent() == true &&
			   map.getTerrains().get(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()) &&
			   map.getTerrains().get(terrainCounter).getRace().equals(raceList.getListElement(0)))
				{

				for(int i = 0; i < stolenRaces.size(); i++)
				{
					if(stolenRaces.get(i).equals(map.getTerrains().get(terrainCounter).getRace().getName()))
					{
						doThief = false;
					}
				}

				if(doThief = true)
					{
					stolenRaces.add(map.getTerrains().get(terrainCounter).getRace().getName());
					System.out.println("Stole 1 coin from " + map.getTerrains().get(terrainCounter).getRace().getName());
					tokenController.linkRaceToPlayer(map.getTerrains().get(terrainCounter).getRace());
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
