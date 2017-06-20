package relics;

import controllers.CombatController_old;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import setup.DeclareCombat;

public class ShinyOrb extends Relic {
	
	private Map map;
	private Player activePlayer;
	private CombatController_old CombatController;
	private int terrainNumber;
	private boolean active = true;
	private MapTester mapTester;
	private DeclareCombat declareCombat;
	private TerrainController terrainController;

	public ShinyOrb(){
		
		name = "Shiny Orb";
		traitText = "Once per turn per opponent, use the Orb to substitute a single"
				+ " active opponent token with one of yours and conquer that adjacent Region.";
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
			CombatController.setMiscModifier(1);
			mapTester.whichAreAttackable();
			declareCombat.processAttack(activePlayer);
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			active = false;
		}
		
		/*
		 * Werkt maar eenmaal dus niet elke speler
		 */
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}
}
