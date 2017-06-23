package specialTokens;

import java.util.Scanner;

import controllers.CombatController_old;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse houdt de status van deze special Token bij en zijn functionaliteit.
 * @author
 */
public class Queen extends SpecialToken {

	Map map;
	Player activePlayer;
	CombatController_old cc;
	private int terrainNumber;
	Scanner scanner;

	@Override
	public void processSpecialToken(Ammy ammy) {

		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.cc = ammy.getCc();

		System.out.println("Welk terrein wil je de queen plaatsen token? ");
		this.terrainNumber = scanner.nextInt()-1;
		changeTerrain(terrainNumber);
		map.getTerrains().get(terrainNumber).setIsImmune(true);
	}

	@Override
	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setIsImmune(false);
		map.getTerrains().get(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrains().get(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;

	}

}
