package relics;

import java.util.ArrayList;

import controllers.MapTester;
import controllers.TerrainController;
import controllers.TokenController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;

public class FroggysRing extends Relic {
	
	Map map;
	boolean active = true;
	int terrainNumber;
	private TerrainController terrainController;
	private MapTester mapTester;
	private int relicIncome;
	private Player activePlayer;
	private int terrainCounter;
	private ArrayList<String> stolenRaces = new ArrayList<String>();
	private boolean doThief;
	private TokenController tokenController;
	
	public FroggysRing(){
		
		name = "Froggy's Ring";
		traitText = "At turn's end, place the Ring in 1 of your Regions to collect a bonus coin "
					+ "from each opponent with at least 1 Active race token bordering the Ring";
	}

	@Override
	public void processRelic(Ammy ammy) {
		relicIncome = 0;
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.tokenController = ammy.getToc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		System.out.println("Doing other shit");
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName())
		{
			terrainController.setAllRedeployableAreas(activePlayer);
			mapTester.whichAreRedeployable(activePlayer);
			terrainController.checkIfRedeployable();
			changeTerrain(terrainController.getAreaPicked());
			active = false;
			System.out.println(terrainController.getAreaPicked());
			terrainController.checkAdjacentToSingleTerrain(map.getTerrain(terrainNumber));
			System.out.println("Did some shit");
			for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
			{
				//System.out.println(activePlayer.getActiveSet().getRace().getName());
				//System.out.println(map.getTerrain(terrainCounter).getRace().getName());
				if(map.getTerrain(terrainCounter).getIsAdjacent() == true && !map.getTerrain(terrainCounter).getRace().getName().equals("Empty ")
						&& !activePlayer.getActiveSet().getRace().getName().equals(map.getTerrain(terrainCounter).getRace().getName()))						//If isAttackable is true
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
						relicIncome++;
					}
				}
				doThief = true;
			}
		}
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
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
	
	public int getRelicIncome() {
		return relicIncome;
	}

	public void setRelicIncome(int relicIncome) {
		this.relicIncome = relicIncome;
	}


}
