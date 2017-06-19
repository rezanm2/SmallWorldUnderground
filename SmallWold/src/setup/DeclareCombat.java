package setup;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import controllers.TokenController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Mummies;
import races.Ogres;
import races.Race;
import relics.FlyingDoormat;
import relics.KillerRabbitSword;
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
	Ammy ammy;
	public DeclareCombat(Ammy ammy)
	{
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.test = ammy.getTest();
		this.playerCreator = ammy.getPlayerCreator();
		this.tc = ammy.getTc();
		this.toc = ammy.getToc();
		this.ammy = ammy;

	}

	public void start(Player activePlayer)
	{
		this.activePlayer = activePlayer;

		System.out.println(activePlayer.getHand().getCurrentTokens());
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Conquest phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + " to attack some stuff. \n");

		tc.setAllAttackableAreas(activePlayer);						//Setting isAttackable for each area player x has
		tc.setAllAdjacentAreas(activePlayer);						//Setting isAdjacent for each area player x has
		tc.setAllRedeployableAreas(activePlayer);					//Setting isReinforcable for each area player x has
		toc.calculateReturnedTokens(activePlayer);

		activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + tc.getReturnedTokens());
		System.out.println("A: Currently, " + " controls the following areas and has "
							+ activePlayer.getHand().getCurrentTokens() + " " + activePlayer.getActiveSet().getRace().getName()
							+ " tokens in their hand.");
		test.whichAreRedeployable(activePlayer);													//Show each area that isReinforcable

		System.out.println("A: Which means that " + " can attack the following areas.");



		map.getTerrain(0).setRelic(new KillerRabbitSword());
		map.getTerrain(0).getRelic().processRelic(ammy);

		while(activePlayer.getHand().getCurrentTokens()>0)
		{
			test.whichAreAttackable();
			processAttack(activePlayer);
			if(cc.isDiceUsed() == true)
			{
				break;
			}
		}
		System.out.println("A: Looks like you're out of tokens or used the diceroll. Combat phase over.");
	}

	public void processAttack(Player activePlayer) {

//		mummy.processAbility(ammy);
//		ogres.processAbility(ammy);
		System.out.println("A: You have " + activePlayer.getHand().getCurrentTokens() + " tokens left.");
		System.out.println("A: Which area do  you wish to attack?");

		tc.checkIfAttackable();

		System.out.println("A: Okay, there's currently " + map.getTerrain(tc.getAreaPicked()).getAmountOfTokens()
							+ " tokens on it, and the place has " + map.getTerrain(tc.getAreaPicked()).getDefense() + " defense."
							+ " You need " + (map.getTerrain(tc.getAreaPicked()).getAmountOfTokens() + map.getTerrain(tc.getAreaPicked())
							.getDefense() + cc.getMiscModifier() + 2) + " tokens to take this area over.\n How many tokens do you wish to use?");


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

	public void setActivePlayer(Player activePlayer)
	{
		this.activePlayer = activePlayer;
	}

	public Player getActivePlayer()
	{
		return activePlayer;
	}
}
