package setup;

import controllers.CombatController;
import controllers.SleepController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import playBoard.Map;

public class Starter
{
	public void start()
	{


		SleepController sleep = new SleepController();
		MapCreator mapCreator = new MapCreator();				//Create a new MapCreator
		PlayerCreator playerCreator = new PlayerCreator();		//Create a new PlayerCreator
		playerCreator.definePlayers();							//Ask how many players there will be, and their names
		playerCreator.printAllPlayers();						//Show all the players and their names
		mapCreator.setupMap(playerCreator.getAmountOfPlayers());//Creating the corresponding map (2-player, 3-player, etc...)

		PickAreas pickAreas = new PickAreas(mapCreator.getMap(), playerCreator.getPlayerList());


		Map map = mapCreator.getMap();							//Make variable "map" the map that the MapCreator made
		map.setEmpty();											//Set all squares to empty

		map.allTerrainsToString();								//Show all the terrains and their types

		pickAreas.start();

		map.allTerrainsToString();								//Show all the terrains and their types

	}
}
