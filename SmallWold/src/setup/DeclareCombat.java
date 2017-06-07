package setup;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainsController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

public class DeclareCombat
{
	CombatController cc;
	MapTester test;
	int code;
	int declaredTokenAmount = -1;
	Map map;
	int tempAreaPicked;
	PlayerCreator playerCreator;
	Player activePlayer;
	Scanner input = new Scanner(System.in);
	boolean validChoice;
	TerrainsController tc;

	public DeclareCombat(Ammy ammy)
	{
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.test = ammy.getTest();
		this.playerCreator = ammy.getPlayerCreator();
		this.activePlayer = ammy.getPlayerCreator().playerList.get(0);
		this.tc = ammy.getTc();
	}

	public void start()
	{
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Conquest phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to attack some stuff. \n");


		activePlayer = playerCreator.playerList.get(0);

		tc.setAllAttackableAreas(activePlayer);						//Setting isAttackable for each area player x has
		tc.setAllAdjacentAreas(activePlayer);						//Setting isAdjacent for each area player x has
		tc.setAllReinforcableAreas(activePlayer);					//Setting isReinforcable for each area player x has

		System.out.println("A: Currently, " + activePlayer.getName() + " controls the following areas and has "
							+ activePlayer.getHand().getCurrentTokens() + activePlayer.getActiveSet().getRace().getTokenType()
							+ " tokens in their hand.");
		test.whichAreReinforcable();													//Show each area that isReinforcable

		System.out.println("A: Which means that " + activePlayer.getName() + " can attack the following areas.");
		test.whichAreAttackable();														//Show each area that isAttackable

		System.out.println("A: Which area do  you wish to attack?");

		tc.checkIfAttackable();

		System.out.println("A: Okay, there's currently " + map.getTerrain(tempAreaPicked).getAmountOfTokens()
							+ " tokens on it, and the place has " + map.getTerrain(tempAreaPicked).getDefense() + " defense."
							+ " You need " + (map.getTerrain(tempAreaPicked).getAmountOfTokens() + map.getTerrain(tempAreaPicked)
							.getDefense() + 2) + " tokens to take this area over.\n How many tokens do you wish to use?");


		while(activePlayer.getHand().getCurrentTokens()>0)
		{
			while(declaredTokenAmount<0 || declaredTokenAmount > activePlayer.getHand().getCurrentTokens())
			{
				declaredTokenAmount = input.nextInt();								//Player declaring amount to attack with
				input.nextLine();
				System.out.print("A: No");
			}
			System.out.println(" problems");
			cc.setDeclaredAmountOfTokens(declaredTokenAmount);					//CombatController taking this declared amount
			cc.calculateCombat(map.getTerrain(tempAreaPicked), activePlayer);	//CombatController calculating the combat done
			tc.setAllAttackableAreas(activePlayer);
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
