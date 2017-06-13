package relics;

import controllers.CombatController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

public class StinkyTrollSocks extends Relic {
	
	Map map;
	boolean active = true;
	int terrainNumber;
	private Player activePlayer;
	private CombatController CombatController;
	
	public StinkyTrollSocks(){
		name = "Stinky Troll's Socks";
		traitText = "Once per turn, use it to conquer 1 Region as if it was empty. Your opponent loses"
					+ "	no token though, redeploying them all at turn's end.";
	}

	@Override
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.CombatController = ammy.getCc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			CombatController.setMiscModifier(22);
			active = false;
		}
		
	}
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}
}
