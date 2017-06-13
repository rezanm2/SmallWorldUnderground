package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class ShinyOrb extends Relic {
	
	public ShinyOrb(){
		
		name = "Shiny Orb";
		traitText = "Once per turn per opponent, use the Orb to substitute a single"
				+ " active opponent token with one of yours and conquer that adjacent Region.";
	}

	@Override
	public void processRelic(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
}
