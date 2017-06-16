package races;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import player.Player;
import races.Race;
import specialTokens.Ancient;

public class Cultists extends Race
{
	Ancient an = new Ancient();
	MapTester mapTester;
	TerrainController terrainController;
	CombatController cc;
	
	public Cultists()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Cultists";
		traitText = "Can place the Great Ancient in the first region, and at the start of the turn. Attack at 1 less around him.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		this.cc = ammy.getCc();
		String yesOrNo = "";
		Scanner scanner = new Scanner(System.in);
		int terrainNumber;
		int counter = 0;
		an.processSpecialToken(ammy);
	}
}
