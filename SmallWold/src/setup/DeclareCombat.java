package setup;

import controllers.CombatController;
import controllers.MapTester;
import playBoard.Map;
import player.Player;

public class DeclareCombat
{
	CombatController cc;
	MapTester test;
	int code;
	Map map;
	PlayerCreator playerCreator;

	public DeclareCombat(Map map, CombatController cc, MapTester test, PlayerCreator playerCreator)
	{
		this.map = map;
		this.cc = cc;
		this.test = test;
		this.playerCreator = playerCreator;
	}



	public void start(Player activePlayer)
	{
		System.out.println("A: All right. Let's start attacking some stuff.");

		System.out.println("A: Let me give you all areas you can attack.");



		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getRace().equals(activePlayer.getActiveSet().getRace()))
			{
				cc.checkIsAdjacent(map.getTerrain(terrainCounter).getElement(0));
			}
		}


		test.whichAreAdjacent();
		System.out.println("A: Which area do  you wish to attack?");
	}
}
