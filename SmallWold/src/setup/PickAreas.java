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
	private int declaredNumber;
	Scanner input = new Scanner(System.in);
	Map map = new Map();
	private List<Player> playerList;

	AbilityListCreator abilityList = new AbilityListCreator();
	RaceListCreator raceList = new RaceListCreator();

	Set activeSetOne;
	Set activeSetTwo;
	Set activeSetThree;
	Set activeSetFour;
	Set activeSetFive;

	public PickAreas(Map map, List<Player> playerList)
	{
		this.map = map;
		this.playerList = playerList;
	}




	public void start()
	{



		activeSetOne = new Set(abilityList.getListElement(0), raceList.getListElement(0));
		playerList.get(0).setActiveSet(activeSetOne);

		activeSetTwo = new Set(abilityList.getListElement(1), raceList.getListElement(1));
		playerList.get(1).setActiveSet(activeSetTwo);

		if(playerList.size() > 2)
		{
			activeSetThree = new Set(abilityList.getListElement(2), raceList.getListElement(2));
			playerList.get(1).setActiveSet(activeSetThree);
		}

		if(playerList.size() > 3)
		{
			activeSetThree = new Set(abilityList.getListElement(3), raceList.getListElement(3));
			playerList.get(1).setActiveSet(activeSetThree);
		}

		if(playerList.size() > 4)
		{
			activeSetThree = new Set(abilityList.getListElement(3), raceList.getListElement(3));
			playerList.get(1).setActiveSet(activeSetThree);
		}



		for(int i=0;i<playerList.size();i++)
		{
			playerList.get(i).setActiveSet(playerList.get(i).getActiveSet());
			System.out.println("For now, " + playerList.get(i).getName() + " is going to be "
							+	playerList.get(i).getActiveSet().getAbility() + " "
							+	playerList.get(i).getActiveSet().getRace().getTokenType() + "." + "\n");
		}


		for(int x=0; x<playerList.size();x++)
		{
			System.out.println("A: Pick 4 areas " + playerList.get(x).getName() + " wants to be on!");
			for(int i=0; i<4; i++)
			{
				areaPicked = input.nextInt() - 1 ;
				input.nextLine();

				System.out.println("A: I'm also going to need a number of tokens.");


				map.getTerrain(areaPicked).setRace(activeSetOne.getRace());;
				System.out.println("A: All right, " + areaPicked + " is now under your control.");
			}
		}

		CombatController cc = new CombatController(map);

	}
}
