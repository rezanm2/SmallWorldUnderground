package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class Empty extends Relic {
	
	private Map map;
	private int terrainNumber;

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}
	
	@Override
	public void processRelic(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}

}
