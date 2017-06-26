package abilities;

import java.util.Scanner;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
public class Vampire extends Ability
{
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
	public void processAbility(Player selfPlayer, Map map) {

		this.selfPlayer = selfPlayer;
		this.map = map;

			System.out.println("Welk terrein wil je replacen met 1 token? ");
			this.terrainNumber = scanner.nextInt()-1;

			if (map.getTerrains().get(terrainNumber).getAmountOfTokens() == 1){
				map.getTerrains().get(terrainNumber).setRace(selfPlayer.getActiveSet().getRace());
				System.out.println(map.getTerrains().get(terrainNumber).getRace().getName());
				selfPlayer.getHand().setCurrentTokens(selfPlayer.getHand().getCurrentTokens() - 1);
			}
	}
}
