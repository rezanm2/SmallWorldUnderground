package relics;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
import terrain.Terrain;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author Bas Dorresteijn
 */
public class StinkyTrollSocks extends Relic {

	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;

	public StinkyTrollSocks(){
		name = "Stinky Troll's Socks";
		traitText = "Once per turn, use it to conquer 1 Region as if it was empty. Your opponent loses"
					+ "	no token though, redeploying them all at turn's end.";
	}

	/**
	 * Handelt combat af alsof er geen tokens op dat gebied zouden stana.
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
