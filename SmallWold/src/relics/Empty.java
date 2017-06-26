package relics;


import playBoard.Map;
import player.Player;
/**
 * Deze klasse bestaat zodat er de relic op "leeg" gezet kan worden.
 * @author Jeroen Zandvliet
 */
public class Empty extends Relic {

	private Map map;
	private int terrainNumber;

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}

	@Override
	public void processRelic(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}

	public void changeTerrain(int terrainNumber) {
	}

}
