package relics;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class ScepterOfAvarice extends Relic implements CalculatableIncome{
	
	private TerrainController terrainController;
	private MapTester mapTester;
	private Map map;
	private int terrainNumber;
	private Player activePlayer;
	private boolean active = true;
	private int relicIncome;

	public ScepterOfAvarice(){
		
		name = "Scepter of Avarice";
		traitText = "At turn's end, place the Scepter in one of your Regions to double the number"
				+ " of coins you recieve from it(except from other players).";
	}
	
	@Override
	public void processRelic(Ammy ammy) {
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName())
		{
			terrainController.setAllRedeployableAreas(activePlayer);
			mapTester.whichAreRedeployable(activePlayer);
			terrainController.checkIfRedeployable();
			System.out.println(map.getTerrain(terrainController.getAreaPicked()).getRelic().getName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrain(terrainController.getAreaPicked()).getRelic().getName());
			active = false;
			
			/*
			 * Ergens hier nog n dubbeling uitvoeren.
			 */
		}
		
	}
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}

	@Override
	public int getRelicIncome() {
		return relicIncome;
	}
}
