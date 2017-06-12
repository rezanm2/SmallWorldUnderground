package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class ScepterOfAvarice extends Relic {
	
	public ScepterOfAvarice(){
		
		name = "Scepter of Avarice";
		traitText = "At turn's end, place the Scepter in one of your Regions to double the number"
				+ " of coins you recieve from it(except from other players).";
	}

	@Override
	public void processRelic(Map map, Player activePlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTerrain(int terrainNumber) {
		// TODO Auto-generated method stub
		
	}
}
