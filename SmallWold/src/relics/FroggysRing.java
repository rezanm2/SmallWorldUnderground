package relics;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;

public class FroggysRing extends Relic {
	
	Map map;
	boolean active = false;
	int terrainNumber;
	private TerrainController terrainController;
	private MapTester mapTester;
	private int relicIncome;
	
	public FroggysRing(){
		
		name = "Froggy's Ring";
		traitText = "At turn's end, place the Ring in 1 of your Regions to collect a bonus coin "
					+ "from each opponent with at least 1 Active race token bordering the Ring";
	}

	@Override
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}

	@Override
	public void processRelic(Ammy ammy) {
	
	}

}
