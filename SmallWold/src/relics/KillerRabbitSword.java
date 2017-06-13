package relics;

import controllers.CombatController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class KillerRabbitSword extends Relic
{
	Map map;
	boolean active = true;
	int terrainNumber;
	private CombatController CombatController;
	private Player activePlayer;
	

	public KillerRabbitSword()
	{
		name = "Sword of the Killer Rabbit";
		traitText = "Use to take control of an area with two tokens less than usual (minimum of 1)";
	}

	@Override
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.CombatController = ammy.getCc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			CombatController.setMiscModifier(2);
			active = false;
		}
		
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}



}
