package specialTokens;

import main.Ammy;
import playBoard.Map;

public class Empty extends SpecialToken {

	private Map map;
	private int terrainNumber;

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}

	@Override
	public void processSpecialToken(Ammy ammy) {
		// TODO Auto-generated method stub

	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrain(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;
	}

}
