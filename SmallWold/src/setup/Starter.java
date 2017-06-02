package setup;

import controllers.CombatController;
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
		DeclareCombat dc = new DeclareCombat(cc);

		MapTester tester = new MapTester(map);					//Create a new mapTester
		map.setEmpty();											//Set all squares to empty
		//Everything above this is setting up the map and players

		//Everything below this is own code
		playerCreator.definePlayers();							//Ask how many players there will be, and their names
		playerCreator.printAllPlayers();						//Show all the players and their names
		map.allTerrainsToString();								//Show all the terrains and their types
		pickRegions.start();									//Players picking their starting regions
		map.allTerrainsToString();								//Show all the terrains and their types

		dc.start();


	}
}
