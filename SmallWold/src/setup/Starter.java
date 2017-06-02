package setup;

import controllers.CombatController;
import controllers.EndTurnController;
import controllers.MapTester;
import controllers.SleepController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import playBoard.Map;

public class Starter
{
	Map map;
	public void start()
	{
		MapCreator mapCreator = new MapCreator();				//Create a new MapCreator
		PlayerCreator playerCreator = new PlayerCreator();		//Create a new PlayerCreator
		playerCreator.defineAmountOfPlayers(); 					//Asks how many players will play the game
		mapCreator.setupMap(playerCreator.getAmountOfPlayers());//Creating the corresponding map (2-player, 3-player, etc...)
		map = mapCreator.getMap();								//Create a new map and fill it with the corresponding map
		PickRegions pickRegions = new PickRegions(mapCreator.getMap(), playerCreator.getPlayerList()); //Create a new PickRegions
		CombatController cc = new CombatController(map);		//Create a new CombatController
		MapTester test = new MapTester(map);					//Create a new mapTester
		DeclareCombat dc = new DeclareCombat(map, cc, test, playerCreator);	//Create a new CombatDeclarer

		map.setEmpty();											//Set all squares to empty
		playerCreator.definePlayers();							//Creates the players

		EndTurnController etc = new EndTurnController(map);
		//Everything above this is setting up the map and players

		//Everything below this is own code

		playerCreator.setDefaultSets();							//Sets the player's default sets
		playerCreator.printAllPlayers();						//Show all the players and their names
//		map.allTerrainsToString();								//Show all the terrains and their types
//		pickRegions.start();									//Players picking their starting regions
//		map.allTerrainsToString();								//Show all the terrains and their types
//		etc.calculateTerrainIncome(playerCreator.getPlayerList().get(0));
//
//
//		System.out.println("A: " + playerCreator.getPlayerList().get(0).getName() + "'s income purely from terrains equals: "
//							+ etc.getIncomeOfTerrains());
//
//		etc.calculateTerrainIncome(playerCreator.getPlayerList().get(1));
//
//		System.out.println("A: " + playerCreator.getPlayerList().get(1).getName() + "'s income purely from terrains equals: "
//				+ etc.getIncomeOfTerrains());

//		dc.start(playerCreator.getPlayerList().get(0));

		cc.checkIsAdjacent("River");
		test.whichAreAdjacent();

	}
}
