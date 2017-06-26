package relics;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author Bas Dorresteijn
 */
public class KillerRabbitSword extends Relic
{
	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;


	public KillerRabbitSword()
	{
		name = "Sword of the Killer Rabbit";
		traitText = "Take control of an area with two tokens less than usual (minimum of 1)";
	}

	/**
	 * Zorgt ervoor dat het gekozen terrein aangevallen kan worden met 2 minder tokens.
	 */
	@Override
	public void processRelic(Player selfPlayer, Map map) {
		this.map = map;
		this.selfPlayer = selfPlayer;
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {

			//declareCombat.processAttack(activePlayer);
			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			active = false;
		}

	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setRelic(new Empty());
		map.getTerrains().get(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}



}
