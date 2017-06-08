package setup;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class RedeployAreas
{
	Ammy ammy;
	Player activePlayer;
	MapTester test;
	TerrainController tc;
	private int declaredTokenAmount;
	private Map map;
	private CombatController cc;
	Scanner input = new Scanner(System.in);

	public RedeployAreas(Ammy ammy)
	{
		this.ammy = ammy;
		this.test = ammy.getTest();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
	}

	public void start(Ammy ammy)
	{
		declaredTokenAmount = 0;

		this.activePlayer = ammy.getActivePlayer();
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Redeployment phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to redeploy his stuff. \n");

		tc.setAllRedeployableAreas(activePlayer);
		tc.calculateReturnedTokens();

		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + tc.getReturnedTokens());



		while(activePlayer.getHand().getCurrentTokens()>0)
		{
			System.out.println(activePlayer.getName() + " has currently got " + activePlayer.getHand().getCurrentTokens()
					+ " " + activePlayer.getActiveSet().getAbility().getType() + " " + activePlayer.getActiveSet().getRace().getName()
					+ " tokens to redeploy on the following areas: ");

			tc.setAllRedeployableAreas(activePlayer);
			test.whichAreRedeployable();

			System.out.println("A: Which area do  you wish to redeploy in?");

			tc.checkIfRedeployable();

			System.out.println("A: How many tokens?");
			declaredTokenAmount = input.nextInt();								//Player declaring amount to attack with
			input.nextLine();

			while(declaredTokenAmount<0 || declaredTokenAmount > activePlayer.getHand().getCurrentTokens())
			{
				System.out.println("A: Too many or too little tokens selected. Please give me a different number.");
				declaredTokenAmount = input.nextInt();								//Player declaring amount to attack with
				input.nextLine();
			}

			activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() - declaredTokenAmount);

			map.getTerrain(tc.getAreaPicked()).setAmountOfTokens(declaredTokenAmount+1);
		}
	}


}
