package setup;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

public class DeclareCombat
{
	CombatController cc;
	MapTester test;
	int code;
	int declaredTokenAmount;
	Map map;
	int tempAreaPicked;
	PlayerCreator playerCreator;
	Player activePlayer;
	Scanner input = new Scanner(System.in);

	boolean validChoice;

	public DeclareCombat(Ammy ammy)
	{
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.test = ammy.getTest();
		this.playerCreator = ammy.getPlayerCreator();
		this.activePlayer = ammy.getActivePlayer();
	}

	public void start()
	{
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Conquest phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to attack some stuff. \n");
		cc.setAllAttackableAreas(playerCreator.playerList.get(0));				//Setting isAttackable for each area player x has
		cc.setAllAdjacentAreas(playerCreator.playerList.get(0));				//Setting isAdjacent for each area player x has
		cc.setAllReinforcableAreas(playerCreator.playerList.get(0));			//Setting isReinforcable for each area player x has

		System.out.println("A: Currently, " + activePlayer.getName() + " controls the following areas.");
		test.whichAreReinforcable();											//Show each area that isReinforcable

		System.out.println("A: Which means that " + activePlayer.getName() + " can attack the following areas.");
		test.whichAreAttackable();												//Show each area that isAttackable

		System.out.println("A: Which area do  you wish to attack?");

		while(validChoice == false)					//As long as a valid choice has not been picked
		{
			tempAreaPicked = input.nextInt() - 1;	//Let the player pick an area to attack
			input.nextLine();
			if(tempAreaPicked >= map.getAllTerrains().size() || tempAreaPicked < 0			//If an invalid area is chosen (number too big
					|| map.getTerrain(tempAreaPicked).getIsAttackable() == false)			//or isn't currently attackable)
			{
				System.out.println("A: Nope, that one isn't on the list! Please pick a different one.");
			}
			else
			{
				validChoice = true;
			}
		}

		System.out.println("A: Okay, there's currently " + map.getTerrain(tempAreaPicked).getAmountOfTokens()
							+ " tokens on it, and the place has " + map.getTerrain(tempAreaPicked).getDefense() + " defense."
							+ " You need " + (map.getTerrain(tempAreaPicked).getAmountOfTokens() + map.getTerrain(tempAreaPicked)
							.getDefense() + 2) + " tokens to take this area over.\n How many tokens do you wish to use?");

		declaredTokenAmount = input.nextInt();		//Player declaring amount to attack with
		input.nextLine();
		cc.setDeclaredAmountOfTokens(declaredTokenAmount);		//CombatController taking this declared amount
		cc.calculateCombat(map.getTerrain(tempAreaPicked), activePlayer);	//CombatController calculating the combat done

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