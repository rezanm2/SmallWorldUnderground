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

	public PickRegions(Ammy ammy)
	{
		this.map = ammy.getMap();
		this.playerList = ammy.getPlayerList();
		this.abilityList = ammy.getAbilityList();
		this.raceList = ammy.getRaceList();
	}


	public void start()
	{
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the PickRegions phase. ~~~~~~~~~ \n\n");

		for(int i=0;i<playerList.size();i++)			//As long as there is players
		{
			System.out.println("For now, " + playerList.get(i).getName() + " is going to be "
							+	playerList.get(i).getActiveSet().getAbility() + " "
							+	playerList.get(i).getActiveSet().getRace().getTokenType() + "." + "\n");
		}


		for(int playerCounter=0; playerCounter<playerList.size();playerCounter++)	//As long as there's players
		{

			if(hasBroken == true)		//If the defaults are selected
			{
				break;					//Break out of picking Areas
			}

			System.out.println("A: Pick 4 areas " + playerList.get(playerCounter).getName() + " wants to be on!");

			for(int terrainPickCounter=0; terrainPickCounter<4; terrainPickCounter++)	//As long as the player has regions left to pick
			{
				validChoice = false;
				while(validChoice == false)					//Player has to pick a non-immune region
				{											//And at this point in time, also a not-picked region yet.
					System.out.println(playerList.get(playerCounter).getName() + " has picked " + terrainPickCounter
										+ " terrains. " + (4- terrainPickCounter) + " left to pick.");

					System.out.println("A: Which area would " + playerList.get(playerCounter).getName() + " like to control?");
					tempAreaPicked = input.nextInt() - 1 ;	//Player picks an area here; -1 because array starts at [0]
					input.nextLine();						//Apparently input.nextInt needs this line

					if(tempAreaPicked == 49)				//If a 50 is input
					{
						this.setDefault();					//Setting the defaults
						validChoice = true;
						setDefaults = true;
						break;								//Break out of the loops.
					}
					
					if(tempAreaPicked>map.getAllTerrains().size()) { 					// checks if area is in the map
						System.out.println("A: Looks like that area's not choosable at the moment. Please pick a different area.");
					}
					
					else {
						if(map.getTerrain(tempAreaPicked).getIsImmune() == true					//If area is immune
							|| !map.getTerrain(tempAreaPicked).getRace().getTokenType()		//or if the area is not empty
							.equals(raceList.getListElement(0).getTokenType()))
							
						{
							System.out.println("A: Looks like that area's not choosable at the moment. Please pick a different area.");
						}
						else
						{
							validChoice = true;
						}
					}	
				}

				if(setDefaults == true)
				{
					break;
				}
				System.out.println("A: I'm also going to need a number of tokens.");

				declaredNumber = input.nextInt();			//Player declaring their number of tokens
				input.nextLine();


				areaPicked = tempAreaPicked;				//Make the area picked definitive

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
