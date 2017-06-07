package setup;

import java.util.Scanner;

import controllers.MapTester;
import controllers.TerrainsController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class RedeployAreas
{
	Ammy ammy;
	Player activePlayer;
	MapTester test;
	TerrainsController tc;
	private boolean validChoice;
	private int tempAreaPicked;
	private Map map;
	Scanner input = new Scanner(System.in);

	public RedeployAreas(Ammy ammy)
	{
		this.ammy = ammy;
		this.test = ammy.getTest();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
	}

	public void start(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Redeployment phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to redeploy his stuff. \n");

		tc.setAllReinforcableAreas(activePlayer);
		tc.calculateReturnedTokens();

		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + tc.getReturnedTokens());

		System.out.println(activePlayer.getName() + " has currently got " + activePlayer.getHand().getCurrentTokens()
							+ " " + activePlayer.getActiveSet().getAbility().getType() + " " + activePlayer.getActiveSet().getRace().getTokenType()
							+ " tokens to redeploy on the following areas: ");


		test.whichAreReinforcable();
		System.out.println("A: Which area do  you wish to redeploy in?");

		tc.checkIfReinforcable();
		System.out.println("A: Okay, " + (tc.getAreaPicked()+1) + " it is.\n How many tokens do you wish to place on it?");
	}


}
