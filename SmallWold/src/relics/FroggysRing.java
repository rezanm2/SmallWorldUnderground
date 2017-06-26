package relics;

import java.util.ArrayList;
import controllers.TerrainController;
import controllers.TokenController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author Bas Dorresteijn
 */
public class FroggysRing extends Relic implements CalculatableIncome{

	Map map;
	boolean active = true;
	int terrainNumber;
	private TerrainController terrainController;
	private int relicIncome;
	private Player activePlayer;
	private int terrainCounter;
	private ArrayList<String> stolenRaces = new ArrayList<String>();
	private boolean doThief;
	private TokenController tokenController;

	public FroggysRing(){

		name = "Froggy's Ring";
		traitText = "At turn's end, place this in 1 of your Regions to collect a bonus coin "
					+ "from each opponent with at least 1 Active race token bordering the Ring";
	}

	/**
	 * Steelt  1 coin per active adjacent ras.
	 */
	@Override
	public void processRelic(Ammy ammy) {
		relicIncome = 0;
		this.terrainController = ammy.getTc();
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.tokenController = ammy.getToc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		System.out.println("Doing other shit");
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName())
		{
			terrainController.allRedeployableAreas(activePlayer.getActiveSet().getRace());
			changeTerrain(terrainController.getAreaPicked());
			active = false;
			System.out.println(terrainController.getAreaPicked());
			terrainController.checkAdjacentToSingleTerrain(map.getTerrains().get(terrainNumber));
			System.out.println("Did some shit");
			for(terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
			{
				//System.out.println(activePlayer.getActiveSet().getRace().getName());
				//System.out.println(map.getTerrain(terrainCounter).getRace().getName());
				if(map.getTerrains().get(terrainCounter).getIsAdjacent() == true && !map.getTerrains().get(terrainCounter).getRace().getName().equals("Empty ")
						&& !activePlayer.getActiveSet().getRace().getName().equals(map.getTerrains().get(terrainCounter).getRace().getName()))						//If isAttackable is true
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
						relicIncome++;
					}
				}
				doThief = true;
			}
		}
	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setRelic(new Empty());
		map.getTerrains().get(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}

	public int getTerrainNumber() {
		return terrainNumber;
	}

	@Override
	public void setActive()
	{
		stolenRaces.clear();
		this.active = true;
	}

	@Override
	public int getRelicIncome() {
		return relicIncome;
	}

	public void setRelicIncome(int relicIncome) {
		this.relicIncome = relicIncome;
	}


}
