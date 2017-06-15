package setup;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import controllers.TokenController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

public class DeclareCombat
{
	CombatController cc;
	MapTester test;
	int code;
	int declaredAmountOfTokens;
	Map map;
	int tempAreaPicked;
	PlayerCreator playerCreator;
	Player activePlayer;
	Scanner input = new Scanner(System.in);
	boolean validChoice;
	TerrainController tc;
	TokenController toc;

	public DeclareCombat(Ammy ammy)
	{
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.test = ammy.getTest();
		this.playerCreator = ammy.getPlayerCreator();
		this.tc = ammy.getTc();
		this.toc = ammy.getToc();
	}

	public void start(Player activePlayer)
	{
		this.activePlayer = activePlayer;

		System.out.println(activePlayer.getHand().getCurrentTokens());
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Conquest phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to attack some stuff. \n");

		tc.setAllAttackableAreas(activePlayer);						//Setting isAttackable for each area player x has
		tc.setAllAdjacentAreas(activePlayer);						//Setting isAdjacent for each area player x has
		tc.setAllRedeployableAreas(activePlayer);					//Setting isReinforcable for each area player x has
		toc.calculateReturnedTokens();

		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + tc.getReturnedTokens());
		System.out.println("A: Currently, " + activePlayer.getName() + " controls the following areas and has "
							+ activePlayer.getHand().getCurrentTokens() + " " + activePlayer.getActiveSet().getRace().getName()
							+ " tokens in their hand.");
		test.whichAreRedeployable(activePlayer);													//Show each area that isReinforcable

		System.out.println("A: Which means that " + activePlayer.getName() + " can attack the following areas.");

		while(activePlayer.getHand().getCurrentTokens()>0)
		{
			test.whichAreAttackable();

			System.out.println("A: You have " + activePlayer.getHand().getCurrentTokens() + " tokens left.");
			System.out.println("A: Which area do  you wish to attack?");

			tc.checkIfAttackable();

			System.out.println("A: Okay, there's currently " + map.getTerrain(tc.getAreaPicked()).getAmountOfTokens()
								+ " tokens on it, and the place has " + map.getTerrain(tc.getAreaPicked()).getDefense() + " defense."
								+ " You need " + (map.getTerrain(tc.getAreaPicked()).getAmountOfTokens() + map.getTerrain(tc.getAreaPicked())
								.getDefense() + 2) + " tokens to take this area over.\n How many tokens do you wish to use?");


			declaredAmountOfTokens = -5;
			while(declaredAmountOfTokens<0 || declaredAmountOfTokens > activePlayer.getHand().getCurrentTokens())
			{
				declaredAmountOfTokens = input.nextInt();								//Player declaring amount to attack with
				input.nextLine();
				System.out.print("A: No");
			}
			System.out.println(" problems");
			cc.setDeclaredAmountOfTokens(declaredAmountOfTokens);					//CombatController taking this declared amount
			cc.calculateCombat(map.getTerrain(tc.getAreaPicked()), activePlayer);	//CombatController calculating the combat done


		}


		System.out.println("A: Looks like you're out of tokens. Combat phase over.");
	}

	public void setActivePlayer(Player activePlayer)
	{
		this.activePlayer = activePlayer;
	}

	public Player getActivePlayer()
	{
		return activePlayer;
	}
}
