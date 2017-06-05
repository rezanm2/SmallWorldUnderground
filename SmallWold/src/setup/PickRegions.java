package setup;

import java.util.List;
import java.util.Scanner;

import controllers.CombatController;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import main.Ammy;
import main.Set;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

public class PickRegions
{
	private boolean hasBroken;
	private boolean validChoice =false;
	private int tempAreaPicked;
	private int areaPicked;
	private int declaredNumber;
	private boolean setDefaults;
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

	public PickRegions(Map map, List<Player> playerList, AbilityListCreator abilityList, RaceListCreator raceList)
	{
		this.map = map;
		this.playerList = playerList;
		this.abilityList = abilityList;
		this.raceList = raceList;
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
				validChoice = false;
				while(validChoice == false)					//Player has to pick a non-immune region
				{											//And at this point in time, also a not-picked region yet.
					System.out.println(playerList.get(playerCounter).getName() + " has picked " + terrainPickCounter
										+ " terrains. " + (4- terrainPickCounter) + " left to pick.");

					System.out.println("A: Which area would " + playerList.get(playerCounter).getName() + " like to control?");
					tempAreaPicked = input.nextInt() - 1 ;
					input.nextLine();

					if(tempAreaPicked == 49)
					{
						this.setDefault();
						validChoice = true;
						setDefaults = true;
						break;
					}


					if(map.getTerrain(tempAreaPicked).getIsImmune() == true					//If area is immune
							|| !map.getTerrain(tempAreaPicked).getRace().getTokenType()		//or if the area is not empty
							.equals(raceList.getListElement(0).getTokenType()) || tempAreaPicked>map.getAllTerrains()
							.size())
					{
						System.out.println("A: Looks like that area's not choosable at the moment. Please pick a different area.");
					}
					else
					{
						validChoice = true;
					}
				}

				if(setDefaults == true)
				{
					break;
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
	}

	public void setDefault()
	{
		System.out.println("A: Yo, imma be setting yo defaults. \n");

		map.getTerrain(0).setRace(playerList.get(0).getActiveSet().getRace());
		map.getTerrain(0).setAmountOfTokens(1);
		map.getTerrain(1).setRace(playerList.get(0).getActiveSet().getRace());
		map.getTerrain(1).setAmountOfTokens(2);

		map.getTerrain(2).setRace(playerList.get(1).getActiveSet().getRace());
		map.getTerrain(2).setAmountOfTokens(3);
		map.getTerrain(3).setRace(playerList.get(1).getActiveSet().getRace());
		map.getTerrain(3).setAmountOfTokens(4);
		map.getTerrain(4).setRace(playerList.get(1).getActiveSet().getRace());
		map.getTerrain(4).setAmountOfTokens(5);
		map.getTerrain(5).setRace(playerList.get(1).getActiveSet().getRace());
		map.getTerrain(5).setAmountOfTokens(6);

		hasBroken = true;
	}
}
