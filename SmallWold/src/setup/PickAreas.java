package setup;

import java.util.List;
import java.util.Scanner;

import controllers.CombatController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import main.Set;
import playBoard.Map;
import player.Player;

public class PickAreas
{

	private int areaPicked;
	Scanner input = new Scanner(System.in);
	Map map = new Map();
	private List<Player> playerList;

	AbilityListCreator abilityList = new AbilityListCreator();
	RaceListCreator raceList = new RaceListCreator();

	Set activeSetOne;

	public PickAreas(Map map, List<Player> playerList)
	{
		this.map = map;
		this.playerList = playerList;
	}




	public void start()
	{

		activeSetOne = new Set(abilityList.getListElement(0), raceList.getListElement(0));
		playerList.get(0).setActiveSet(activeSetOne);

		playerList.get(0).setActiveSet(playerList.get(0).getActiveSet());
		System.out.println("For now, you're going to be " + playerList.get(0).getActiveSet().getAbility()
				+ " " + playerList.get(0).getActiveSet().getRace().getTokenType() + "." + "\n");
		System.out.println("A: Pick 4 areas you wanna be on!");
		for(int i=0; i<4; i++)
		{
			areaPicked = input.nextInt();
			input.nextLine();
			map.getTerrain(areaPicked - 1).setRace(activeSetOne.getRace());;
			System.out.println("A: All right, " + areaPicked + " is now under your control.");
		}

		CombatController cc = new CombatController(map);

	}
}
