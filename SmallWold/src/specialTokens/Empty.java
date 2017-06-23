package specialTokens;

import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse bestaat zodat de specialToken op "leeg" gezet kan worden.
 * @author
 */
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
		map.getTerrains().get(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrains().get(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;
	}

}
