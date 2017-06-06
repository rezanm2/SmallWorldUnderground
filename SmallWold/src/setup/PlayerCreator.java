package setup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import main.Ammy;
import main.Set;
import player.Player;

public class PlayerCreator
{
	Ammy ammy;
	private int amountOfPlayers;
	String nameOne = "Derevi";
	String nameTwo = "Sydisi";
	String nameThree = "Trostani";
	String nameFour = "Avacyn";
	String nameFive = "Scion";
	String tempName;


	List<Player> playerList = new ArrayList<Player>();
	AbilityListCreator abilityList = new AbilityListCreator();
	RaceListCreator raceList = new RaceListCreator();
	Set activeSetOne;
	Set activeSetTwo;
	Set activeSetThree;
	Set activeSetFour;
	Set activeSetFive;
	Scanner input = new Scanner(System.in);


	public void setDefaultSets()

	{
		activeSetOne = new Set(abilityList.getListElement(1), raceList.getListElement(1));	//Setting random set defaults for players
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
	}


	public void defineAmountOfPlayers()
	{
		System.out.println("A: Hey there! My name's Ammy. I'll be your guide for the console-version of SmallWorld Underground!");
		System.out.println("A: I'll try to make sure you understand what's going on in your console.");
		System.out.println("A: I'll probably get replaced by buttons, but eh... for now, I work.");
		System.out.println("A: I'm just gonna have to ask you a few questions before I can start your game." + "\n");


		while(amountOfPlayers <= 1 || amountOfPlayers > 5)					//As long as there's no good amount of players selected
		{
			System.out.println("A: With how many players do you wish to play?");
			amountOfPlayers = input.nextInt();								//User selecting amount of Players
			if(amountOfPlayers <= 1 || amountOfPlayers > 5)					//Can't select a map outside boundaries
			{
				System.out.println("A: I'm sorry. I can't handle that amount of players! Soo...");
			}
		}

		System.out.println("A: All right, got it. " + amountOfPlayers + " players it is." + "\n");
		input.nextLine();													//Apparently .nextInt needs this line
	}

	public void definePlayers()
	{
		System.out.println("A: Give me player one's name please");
		tempName = input.nextLine();	//Entering player one's name


		if(tempName.isEmpty())												//If no name entered, use default
		{
			System.out.println("A: No name? I guess I'll call you " + nameOne + "\n");
		}
		else
		{
			nameOne = tempName;												//Else, use the name entered
			System.out.println("A: Okay, " + nameOne + " it is." + "\n");
		}

		System.out.println("A: Give me player two's name please");
		tempName = input.nextLine();						//Entering player two's name
		if(tempName.isEmpty())								//If no name entered, use default
		{
			System.out.println("A: No name? I guess I'll call you " + nameTwo + "\n");
		}
		else
		{
			nameTwo = tempName;								//Else, use the name entered
			System.out.println("A: Okay, " + nameTwo + " it is." + "\n");
		}

		if(amountOfPlayers == 2)							//If play is going to happen on the 2-player board
		{
			createPlayers(nameOne, nameTwo);				//Create the two players with their respective names!
		}

		if(amountOfPlayers > 2)								//If there's more than two players
		{
			System.out.println("A: Give me player three's name please");
			tempName = input.nextLine();					//Enter player three's name
			if(tempName.isEmpty())							//If empty, use the default name
			{
				System.out.println("A: No name? I guess I'll call you " + nameThree + "\n");
			}

			else
			{
				nameThree = tempName;						//Else, use the entered name
				System.out.println("A: Okay, " + nameThree + " it is." + "\n");
			}

			if(amountOfPlayers == 3)						//If playing on the 3-player board
			{
				createPlayers(nameOne, nameTwo, nameThree);	//Create the players with their respective names
			}
		}

		if(amountOfPlayers > 3)
		{
			System.out.println("A: Give me player four's name please");
			tempName = input.nextLine();
			if(tempName.isEmpty())
			{
				System.out.println("A: No name? I guess I'll call you " + nameFour + "\n");
			}
			else
			{
				nameFour = tempName;
				System.out.println("A: Okay, " + nameFour + " it is." + "\n");
			}

			if(amountOfPlayers == 4)
			{
				createPlayers(nameOne, nameTwo, nameThree, nameFour);
			}

		}

		if(amountOfPlayers > 4)
		{
			System.out.println("A: Give me player five's name please");
			tempName = input.nextLine();
			if(tempName.isEmpty())
			{
				System.out.println("A: No name? I guess I'll call you " + nameFive + "\n");
			}
			else
			{
				nameFive = tempName;
				System.out.println("A: Okay, " + nameFive + " it is." + "\n");
			}

			if(amountOfPlayers == 5)
			{
				createPlayers(nameOne, nameTwo, nameThree, nameFour, nameFive);
			}

		}
	}


	public void createPlayers(String nameOne, String nameTwo)		//Bunch of playercreators, all the same except
	{
		System.out.println("A: Creating 2 players...");//for the amount of names set
		Player playerOne = new Player(nameOne);						//Creating the actual Player object
		this.playerList.add(playerOne);									//Adding the player to the list of players in the game
		Player playerTwo = new Player(nameTwo);
		this.playerList.add(playerTwo);
		System.out.println("A: Done creating 2 players...");
	}

	public void createPlayers(String nameOne, String nameTwo, String nameThree)
	{
		System.out.println("A: Creating 3 players...");
		Player playerOne = new Player(nameOne);
		this.playerList.add(playerOne);
		Player playerTwo = new Player(nameTwo);
		this.playerList.add(playerTwo);
		Player playerThree = new Player(nameThree);
		this.playerList.add(playerThree);
		System.out.println("A: Done creating 3 players...");
	}

	public void createPlayers(String nameOne, String nameTwo, String nameThree, String nameFour)
	{
		System.out.println("A: Creating 4 players...");
		Player playerOne = new Player(nameOne);
		this.playerList.add(playerOne);
		Player playerTwo = new Player(nameTwo);
		this.playerList.add(playerTwo);
		Player playerThree = new Player(nameThree);
		this.playerList.add(playerThree);
		Player playerFour = new Player(nameFour);
		this.playerList.add(playerFour);
		System.out.println("A: Done creating 4 players...");
	}

	public void createPlayers(String nameOne, String nameTwo, String nameThree, String nameFour, String nameFive)
	{
		System.out.println("A: Creating 5 players...");
		Player playerOne = new Player(nameOne);
		this.playerList.add(playerOne);
		Player playerTwo = new Player(nameTwo);
		this.playerList.add(playerTwo);
		Player playerThree = new Player(nameThree);
		this.playerList.add(playerThree);
		Player playerFour = new Player(nameFour);
		this.playerList.add(playerFour);
		Player playerFive = new Player(nameFive);
		this.playerList.add(playerFive);
		System.out.println("A: Done creating 5 players...");

	}

	public void printAllPlayers()
	{
		System.out.println("\n" + "A: Getting all players. Amount: " + playerList.size() + "\n");
		for(int i=0;i<playerList.size();i++)
		{
			System.out.println("Player:  Name");
			System.out.println("   " + (i+1) + "	" + playerList.get(i).getName());
		}
		System.out.println();
	}


	public String getNameOne() {
		return nameOne;
	}


	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}


	public String getNameTwo() {
		return nameTwo;
	}


	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}


	public String getNameThree() {
		return nameThree;
	}


	public void setNameThree(String nameThree) {
		this.nameThree = nameThree;
	}


	public String getNameFour() {
		return nameFour;
	}


	public void setNameFour(String nameFour) {
		this.nameFour = nameFour;
	}


	public String getNameFive() {
		return nameFive;
	}


	public void setNameFive(String nameFive) {
		this.nameFive = nameFive;
	}


	public String getTempName() {
		return tempName;
	}


	public void setTempName(String tempName) {
		this.tempName = tempName;
	}


	public List<Player> getPlayerList() {
		return playerList;
	}


	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public void setAmountOfPlayers(int amountOfPlayers) {
		this.amountOfPlayers = amountOfPlayers;
	}

	public int getAmountOfPlayers()
	{
		return amountOfPlayers;
	}


}
