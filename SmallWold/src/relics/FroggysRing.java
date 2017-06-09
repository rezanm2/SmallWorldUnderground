package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class FroggysRing extends Relic {
	
	public FroggysRing(){
		
		name = "Froggy's Ring";
		traitText = "At turn's end, place the Ring in 1 of your Regions to collect a bonus coin "
					+ "from each opponent with at least 1 Active race token bordering the Ring";
	}

	@Override
	public void processRelic(Map map, Player activePlayer) {
		// TODO Auto-generated method stub
		
	}

}
