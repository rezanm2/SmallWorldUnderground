package relics;

import controllers.CombatController;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class FlyingDoormat extends Relic {
	
	//TerrainController tc;
	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;
	
	public FlyingDoormat(){
		name = "Flying Doormat";
		traitText = "Once per turn, use it to conquer any Region, not just an adjacent one.";
	}

	
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		System.out.println(map.getTerrain(terrainNumber).getTerrainName());
		System.out.println(map.getTerrain(terrainNumber).getRelic().getName());
		System.out.println(map.getTerrain(terrainNumber).getRace().getName());
		
		
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getAllTerrains().size(); i++) {
				map.getTerrain(i).setIsAttackable(true);
			}
			System.out.println("Set everything attackable");
			active = false;
		}
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}
}
