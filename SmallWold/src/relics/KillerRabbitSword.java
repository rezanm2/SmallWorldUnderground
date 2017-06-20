package relics;

import controllers.CombatController_old;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import setup.DeclareCombat;

public class KillerRabbitSword extends Relic
{
	Map map;
	boolean active = true;
	int terrainNumber;
	private CombatController_old CombatController;
	private Player activePlayer;
	private MapTester mapTester;
	private DeclareCombat declareCombat;
	private TerrainController terrainController;
	

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
		this.mapTester = ammy.getTest();
		this.declareCombat = ammy.getDc();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			CombatController.setMiscModifier(2);
			mapTester.whichAreAttackable();
			declareCombat.processAttack(activePlayer);
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			active = false;
		}
		
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}



}
