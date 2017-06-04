package setup;

import ammy.Ammy;
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
	Ammy ammy = new Ammy();
	public void start()
	{
		ammy.playerSetup();
		ammy.createAccordingMap();
		ammy.createCreators();
		ammy.getMap().allTerrainsToString();
		//playerCreator.definePlayers();							//Creates the players

		//Everything above this is setting up the map and players

		//Everything below this is own code

//		playerCreator.setDefaultSets();							//Sets the player's default sets
//		playerCreator.printAllPlayers();						//Show all the players and their names
//		map.allTerrainsToString();								//Show all the terrains and their types
//		pickRegions.start();									//Players picking their starting regions
//		map.allTerrainsToString();								//Show all the terrains and their types
//		etc.calculateTerrainIncome(playerCreator.getPlayerList().get(0));

	}
}
