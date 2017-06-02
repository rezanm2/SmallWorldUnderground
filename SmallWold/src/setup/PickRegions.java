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
	private boolean hasBroken;
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
		for(int i=0;i<playerList.size();i++)
		{
			playerList.get(i).setActiveSet(playerList.get(i).getActiveSet());
			System.out.println("For now, " + playerList.get(i).getName() + " is going to be "
							+	playerList.get(i).getActiveSet().getAbility() + " "
							+	playerList.get(i).getActiveSet().getRace().getTokenType() + "." + "\n");
		}


		for(int playerCounter=0; playerCounter<playerList.size();playerCounter++)
		{
			if(hasBroken == true)
			{
				break;
			}

			System.out.println("A: Pick 4 areas " + playerList.get(playerCounter).getName() + " wants to be on!");

			for(int terrainPickCounter=0; terrainPickCounter<4; terrainPickCounter++)
			{
				System.out.println(playerList.get(playerCounter).getName() + " has picked " + terrainPickCounter
									+ " terrains. " + (4- terrainPickCounter) + " left to pick.");

				tempAreaPicked = input.nextInt() - 1 ;
				input.nextLine();
				if(tempAreaPicked == 49)
				{
					this.setDefault();
					break;
				}

				if(map.getTerrain(tempAreaPicked).getRace().getTokenType().equals(raceList.getListElement(0).getTokenType())) // WORK IN PROGRESS
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

	public void setDefault()
	{
		System.out.println("A: Yo, here be yo defaults.");

		map.getTerrain(0).setRace(raceList.getListElement(1));
		map.getTerrain(0).setAmountOfTokens(1);
		map.getTerrain(1).setRace(raceList.getListElement(1));
		map.getTerrain(1).setAmountOfTokens(2);

		map.getTerrain(2).setRace(raceList.getListElement(2));
		map.getTerrain(2).setAmountOfTokens(3);
		map.getTerrain(3).setRace(raceList.getListElement(2));
		map.getTerrain(3).setAmountOfTokens(4);
		map.getTerrain(4).setRace(raceList.getListElement(2));
		map.getTerrain(4).setAmountOfTokens(5);
		map.getTerrain(5).setRace(raceList.getListElement(2));
		map.getTerrain(5).setAmountOfTokens(6);

		hasBroken = true;
	}
}
