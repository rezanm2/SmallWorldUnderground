package setup;

import java.util.List;
import java.util.Scanner;

import controllers.CombatController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import main.Set;
import playBoard.Map;
import player.Player;

public class PickRegions
{
	private int tempAreaPicked;
	private int areaPicked;
	private int declaredNumber;
	Scanner input = new Scanner(System.in);
	Map map;
	private List<Player> playerList;

	AbilityListCreator abilityList = new AbilityListCreator();
	RaceListCreator raceList = new RaceListCreator();

	Set activeSetOne;
	Set activeSetTwo;
	Set activeSetThree;
	Set activeSetFour;
	Set activeSetFive;

	public PickRegions(Map map, List<Player> playerList)
	{
		this.map = map;
		this.playerList = playerList;
	}




	public void start()
	{



		activeSetOne = new Set(abilityList.getListElement(1), raceList.getListElement(1));
		playerList.get(0).setActiveSet(activeSetOne);

		activeSetTwo = new Set(abilityList.getListElement(2), raceList.getListElement(2));
		playerList.get(1).setActiveSet(activeSetTwo);

		if(playerList.size() > 2)
		{
			activeSetThree = new Set(abilityList.getListElement(3), raceList.getListElement(3));
			playerList.get(2).setActiveSet(activeSetThree);
		}

		if(playerList.size() > 3)
		{
			activeSetFour = new Set(abilityList.getListElement(4), raceList.getListElement(4));
			playerList.get(3).setActiveSet(activeSetFour);
		}

		if(playerList.size() > 4)
		{
			activeSetFive = new Set(abilityList.getListElement(5), raceList.getListElement(5));
			playerList.get(4).setActiveSet(activeSetFive);
		}



		for(int i=0;i<playerList.size();i++)
		{
			playerList.get(i).setActiveSet(playerList.get(i).getActiveSet());
			System.out.println("For now, " + playerList.get(i).getName() + " is going to be "
							+	playerList.get(i).getActiveSet().getAbility() + " "
							+	playerList.get(i).getActiveSet().getRace().getTokenType() + "." + "\n");
		}


		for(int playerCounter=0; playerCounter<playerList.size();playerCounter++)
		{
			System.out.println("A: Pick 4 areas " + playerList.get(playerCounter).getName() + " wants to be on!");

			for(int terrainPickCounter=0; terrainPickCounter<4; terrainPickCounter++)
			{
				System.out.println(playerList.get(playerCounter).getName() + " has picked " + terrainPickCounter
									+ " terrains. " + (4- terrainPickCounter) + " left to pick.");

				tempAreaPicked = input.nextInt() - 1 ;
				input.nextLine();
				if(map.getTerrain(tempAreaPicked).getRace().equals(raceList.getListElement(0))) // WORK IN PROGRESS
				{
					System.out.println("A: Sorry, that terrain has already been picked. Please pick a different one.");
				}

				System.out.println("A: I'm also going to need a number of tokens.");
				declaredNumber = input.nextInt();
				input.nextLine();


				areaPicked = tempAreaPicked;

				map.getTerrain(areaPicked).setAmountOfTokens(declaredNumber);
				map.getTerrain(areaPicked).setRace(playerList.get(playerCounter).getActiveSet().getRace());;
				System.out.println("A: All right, " + (1 + areaPicked) + " is now under your control with "
									+ map.getTerrain(areaPicked).getAmountOfTokens() + ".\n");
			}
		}

		CombatController cc = new CombatController(map);

	}
}
