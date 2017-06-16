package specialTokens;

import java.util.Scanner;

import controllers.CombatController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Queen extends SpecialToken {

	Map map;
	Player activePlayer;
	CombatController cc;
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
		map.getTerrain(terrainNumber).setIsImmune(true);
	}

	@Override
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setIsImmune(false);
		map.getTerrain(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrain(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;

	}

}
