package abilities;

import java.util.Scanner;

import controllers.CombatController_old;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Vampire extends Ability
{
	CombatController_old cc;
	Map map;
	private int terrainNumber;
	Scanner scanner = new Scanner(System.in);

	public Vampire()
	{
		amountOfTokens = 5;
		name = "Vampire";
		traitText = "Replace one single opponent token with one single vampire token. That token is killed, even immortal.";
	}

	/**
	 * Herplaatst een vijandelijke token met een eigen token.
	 */
	@Override
	public void processAbility(Ammy ammy) {

		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.cc = ammy.getCc();

			System.out.println("Welk terrein wil je replacen met 1 token? ");
			this.terrainNumber = scanner.nextInt()-1;

			if (map.getTerrains().get(terrainNumber).getAmountOfTokens() == 1){
				map.getTerrains().get(terrainNumber).setRace(activePlayer.getActiveSet().getRace());
				System.out.println(map.getTerrains().get(terrainNumber).getRace().getName());
				activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() - 1);
			}
	}
}
