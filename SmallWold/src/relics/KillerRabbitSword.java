package relics;

import controllers.CombatController_old;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import setup.DeclareCombat;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author
 */
public class KillerRabbitSword extends Relic
{
	Map map;
	boolean active = true;
	int terrainNumber;
	private CombatController_old CombatController;
	private Player activePlayer;
	private DeclareCombat declareCombat;
	private TerrainController terrainController;


	public KillerRabbitSword()
	{
		name = "Sword of the Killer Rabbit";
		traitText = "Take control of an area with two tokens less than usual (minimum of 1)";
	}

	/**
	 * Zorgt ervoor dat het gekozen terrein aangevallen kan worden met 2 minder tokens.
	 */
	@Override
	public void processRelic(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.CombatController = ammy.getCc();
		this.declareCombat = ammy.getDc();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			CombatController.setMiscModifier(2);
			declareCombat.processAttack(activePlayer);
			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			active = false;
		}

	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setRelic(new Empty());
		map.getTerrains().get(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}



}
