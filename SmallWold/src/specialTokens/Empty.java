package specialTokens;


import playBoard.Map;
import player.Player;
/**
 * Deze klasse bestaat zodat de specialToken op "leeg" gezet kan worden.
 * @author Marinus van den Oever, Reza Naser
 */
public class Empty extends SpecialToken {

	private Map map;
	private int terrainNumber;
	protected Player selfPlayer;

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}

	@Override
	public void processSpecialToken(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrains().get(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;
	}

}
