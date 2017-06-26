package relics;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author Bas Dorresteijn
 */
public class FlyingDoormat extends Relic {

	//TerrainController tc;
	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;

	public FlyingDoormat(){
		name = "Flying Doormat";
		traitText = "Any region is considered adjacent";
	}


	/**
	 * Zorgt ervoor dat alle terrein aanvalbaar zijn.
	 */
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}

		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getTerrains().size(); i++) {
				if(!map.getTerrains().get(i).getTerrainName().equals("Chasm") && !map.getTerrains().get(i).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName())) {
					map.getTerrains().get(i).setIsAttackable(true);
				}
			}
			System.out.println("Set everything attackable");
			//declareCombat.processAttack(activePlayer);
			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			active = false;
		}
	}

	/**
	 * Zet de relic neer op de plek waar hij voor gebruikt is.
	 */
	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setRelic(new Empty());
		map.getTerrains().get(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}
}
