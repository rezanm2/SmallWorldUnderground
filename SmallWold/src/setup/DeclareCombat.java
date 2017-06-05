package setup;

import controllers.CombatController;
import controllers.MapTester;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class DeclareCombat
{
	CombatController cc;
	MapTester test;
	int code;
	Map map;
	PlayerCreator playerCreator;
	Player activePlayer;

	public DeclareCombat(Map map, CombatController cc, MapTester test, PlayerCreator playerCreator, Player activePlayer)
	{
		this.map = map;
		this.cc = cc;
		this.test = test;
		this.playerCreator = playerCreator;
		this.activePlayer = activePlayer;
	}

	public void start()
	{
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Conquest phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to attack some stuff. \n");
		cc.setAllAttackableAreas(playerCreator.playerList.get(0));
		cc.setAllAdjacentAreas(playerCreator.playerList.get(0));
		cc.setAllReinforcableAreas(playerCreator.playerList.get(0));

		System.out.println("A: Currently, " + activePlayer.getName() + " controls the following areas.");
		test.whichAreReinforcable();

		System.out.println("A: Which means that " + activePlayer.getName() + " can attack the following areas.");
		test.whichAreAttackable();
		System.out.println("A: Which area do  you wish to attack?");

	}
}
