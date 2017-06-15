package specialTokens;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Ancient extends SpecialToken {
	Map map;
	MapTester mapTester;
	CombatController cc;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;
	Scanner scanner = new Scanner(System.in);

	@Override
	public void processSpecialToken(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();

		terrainController.setAllRedeployableAreas(activePlayer);
		mapTester.whichAreRedeployable(activePlayer);
		System.out.println("Op welk terrein wil je de Ancient zetten?");
		terrainNumber = scanner.nextInt();
		changeTerrain(terrainNumber);

		if(map.getTerrain(terrainNumber).getRace() == activePlayer.getActiveSet().getRace()){
			map.getTerrain(this.terrainNumber).setIsImmune(true);

//			if(cc.getTerrain() == terrainController.checkAdjacentToSingleTerrain(map.getTerrain(this.terrainNumber)));
//			cc.setMiscModifier(1);
		}
	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setIsImmune(false);
		map.getTerrain(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrain(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;
	}
}
