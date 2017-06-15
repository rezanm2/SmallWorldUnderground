package setup;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import controllers.TokenController;
import listCreators.RaceListCreator;
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
	RaceListCreator raceList;
	TokenController toc;

	public RedeployAreas(Ammy ammy)
	{
		this.ammy = ammy;
		this.test = ammy.getTest();
		this.tc = ammy.getTc();
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.raceList = ammy.getRaceList();
		this.toc = ammy.getToc();
	}

	public void start(Ammy ammy)
	{
		declaredTokenAmount = 0;

		this.activePlayer = ammy.getActivePlayer();
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Redeployment phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to redeploy his stuff. \n");

		tc.setAllRedeployableAreas(activePlayer);
		toc.calculateReturnedTokens();

		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + tc.getReturnedTokens());



		while(activePlayer.getHand().getCurrentTokens()>0)
		{
			System.out.println(activePlayer.getName() + " has currently got " + activePlayer.getHand().getCurrentTokens()
					+ " " + activePlayer.getActiveSet().getAbility().getName() + " " + activePlayer.getActiveSet().getRace().getName()
					+ " tokens to redeploy on the following areas: ");

			tc.setAllRedeployableAreas(activePlayer);

			test.whichAreRedeployable(activePlayer);


			System.out.println("A: Which area do  you wish to redeploy in?");

			tc.checkIfRedeployable();

			System.out.println("A: How many tokens do you wish to be on the terrain?");
			declaredTokenAmount = input.nextInt();								//Player declaring amount to attack with
			input.nextLine();

			if(declaredTokenAmount == 0)
			{
				System.out.println("A: Selecting 0 tokens means you'll pull out of the region. Pick 0 again if you're sure.");
				declaredTokenAmount = input.nextInt();								//Player declaring amount to attack with
				input.nextLine();
				if(declaredTokenAmount == 0)
				{
					System.out.println("Okay, sure.");

					activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens()
							+ map.getTerrain(tc.getAreaPicked()).getAmountOfTokens() - declaredTokenAmount);

					map.getTerrain(tc.getAreaPicked()).setAmountOfTokens(0);
					map.getTerrain(tc.getAreaPicked()).setRace(raceList.getListElement(0));


				}
			}
			while(declaredTokenAmount<0 || declaredTokenAmount > activePlayer.getHand().getCurrentTokens() + map.getTerrain(tc.getAreaPicked()).getAmountOfTokens())
			{
				System.out.println("A: Too many or too little tokens selected. Please give me a different number.");
				declaredTokenAmount = input.nextInt();								//Player declaring amount to attack with
				input.nextLine();
			}

			activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens()
					+ map.getTerrain(tc.getAreaPicked()).getAmountOfTokens() - declaredTokenAmount);

			map.getTerrain(tc.getAreaPicked()).setAmountOfTokens(declaredTokenAmount);
		}
	}


}
