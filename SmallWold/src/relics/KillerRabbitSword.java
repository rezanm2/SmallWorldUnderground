package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class KillerRabbitSword extends Relic
{
	Map map;
	boolean active = false;
	int terrainNumber;

	public KillerRabbitSword()
	{
		name = "Sword of the Killer Rabbit";
		traitText = "Use to take control of an area with two tokens less than usual (minimum of 1)";
	}

	@Override
	public void changeTerrain(int terrainNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processRelic(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}



}
