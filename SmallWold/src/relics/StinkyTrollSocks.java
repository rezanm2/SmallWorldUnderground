package relics;

import controllers.CombatController_old;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author
 */
public class StinkyTrollSocks extends Relic {

	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private CombatController_old CombatController;
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
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.CombatController = ammy.getCc();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			CombatController.setMiscModifier(22);
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
