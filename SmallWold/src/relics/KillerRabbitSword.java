package relics;

import controllers.CombatController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class KillerRabbitSword extends Relic
{
	Map map;
	boolean active = false;
	int terrainNumber;
	private CombatController CombatController;
	

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
		this.CombatController = ammy.getCc();
		CombatController.setMiscModifier(2);
	}



}
