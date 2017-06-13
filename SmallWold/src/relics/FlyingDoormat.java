package relics;

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
	
	public FlyingDoormat(){
		name = "Flying Doormat";
		traitText = "Once per turn, use it to conquer any Region, not just an adjacent one.";
	}

	
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			System.out.println(map.getTerrain(i).getRelic().getName());
			System.out.println(name);
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getAllTerrains().size(); i++) {
				map.getTerrain(i).setIsAttackable(true);
				System.out.println("Setting terrain " + map.getTerrain(i).getTerrainName() + " to attackable");
		
			}
			System.out.println("Set everything attackable");
			active = false;	
		}
			
	}

}
