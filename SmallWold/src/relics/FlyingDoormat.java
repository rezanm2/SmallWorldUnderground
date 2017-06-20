package relics;

import controllers.CombatController_old;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import setup.DeclareCombat;

public class FlyingDoormat extends Relic {
	
	//TerrainController tc;
	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;
	private DeclareCombat declareCombat;
	private MapTester mapTester;
	
	public FlyingDoormat(){
		name = "Flying Doormat";
		traitText = "Once per turn, use it to conquer any Region, not just an adjacent one.";
	}

	
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.declareCombat = ammy.getDc();
		this.mapTester = ammy.getTest();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getAllTerrains().size(); i++) {
				if(!map.getTerrain(i).getTerrainName().equals("Chasm") && !map.getTerrain(i).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName())) {
					map.getTerrain(i).setIsAttackable(true);
				}
			}
			System.out.println("Set everything attackable");
			mapTester.whichAreAttackable();
			declareCombat.processAttack(activePlayer);
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			active = false;
		}
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}
}
