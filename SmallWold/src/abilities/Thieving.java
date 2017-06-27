package abilities;

import java.util.ArrayList;
import controllers.TerrainController;
import controllers.TokenController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
public class Thieving extends Ability implements CalculatableIncome
{
	TerrainController tc;
	Map map;
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
	public void processAbility(Player selfPlayer, Map map) {

		this.selfPlayer = selfPlayer;
		this.map = map;

		tc.allAdjacentAreas(selfPlayer.getActiveSet().getRace());

		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrains().get(terrainCounter).getIsAdjacent() == true &&
			   map.getTerrains().get(terrainCounter).getRace().equals(selfPlayer.getActiveSet().getRace()))
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
