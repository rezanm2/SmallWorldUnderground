package races;

import java.util.Scanner;
import controllers.TerrainController;
import main.Ammy;
import player.Player;
import races.Race;
import specialTokens.Ancient;

/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Marinus van den Oever
 */
public class Cultists extends Race
{
	Ancient an = new Ancient();
	TerrainController terrainController;

	public Cultists()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Cultists";
		traitText = "Can place the Great Ancient in the first region, and at the start of the turn. Attack at 1 less around him.";
	}

	/**
	 * Verzet de Ancient One.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		String yesOrNo = "";
		Scanner scanner = new Scanner(System.in);
		int terrainNumber;
		int counter = 0;
		an.processSpecialToken(ammy);
	}
}
