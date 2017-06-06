package setup;

import controllers.CombatController;
import controllers.EndTurnController;
import controllers.MapTester;
import controllers.SleepController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import main.Ammy;
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
		ammy.setEverythingOnAmmy();
		ammy.startGame();

	}
}
