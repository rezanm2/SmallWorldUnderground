package setup;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import abilities.Ability;
import abilities.Adventurous;
import abilities.Fisher;
import abilities.Flocking;
import abilities.Frightened;
import abilities.Immortal;
import abilities.Magic;
import abilities.Martyr;
import abilities.Mining;
import abilities.Muddy;
import abilities.Mystic;
import abilities.Quarreling;
import abilities.Reborn;
import abilities.Royal;
import abilities.Shield;
import abilities.Stone;
import abilities.Thieving;
import abilities.Tomb;
import abilities.Vampire;
import abilities.Vanishing;
import abilities.Vengeful;
import abilities.Wise;
import javafx.scene.control.Button;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import listCreators.RelicListCreator;
import main.Ammy;
import main.Set;
import player.Player;
import races.Cultists;
import races.Drow;
import races.Flames;
import races.Gnomes;
import races.Kraken;
import races.Liches;
import races.Lizardmen;
import races.Monster;
import races.Mudmen;
import races.Mummies;
import races.Ogres;
import races.Race;
import races.ShadowMimes;
import races.Shrooms;
import races.Spiderines;
import races.WillOWisp;

public  class Decline {
		Player activePlayer;
		AbilityListCreator abilityList = new AbilityListCreator();
		RaceListCreator raceList = new RaceListCreator();
		List<Player> playerList;
		ShadowMimes shadowMimes =new ShadowMimes();

		Set emptySet = new Set(abilityList.getListElement(0), raceList.getListElement(0));

		private int getal1;
		private int getal2;
		private Race tempRace;
		private Ability tempAbility;
		private int setNr;
		private Scanner scanner;
		Random r = new Random();
		String yesOrNo ="";

		public Decline(Ammy ammy)
		{
			this.activePlayer = ammy.getActivePlayer();
			this.abilityList = ammy.getAbilityList();
			this.raceList = ammy.getRaceList();
			this.playerList = ammy.getPlayerList();
			shuffleSets();
		}
		public void goInDecline(Player activePlayer)
		{

			activePlayer.setDeclineSet(activePlayer.getActiveSet());
			activePlayer.setActiveSet(emptySet);

			System.out.println(activePlayer.getDeclineSet().getAbility().getName() + " and "
								+ activePlayer.getDeclineSet().getRace().getName() + " for player: "
								+ activePlayer.getName() +  " are declined");

			System.out.println(activePlayer.getActiveSet().getAbility().getName() + " and "
					+ activePlayer.getActiveSet().getRace().getName() + " for player: "
					+ activePlayer.getName() +  " are active.\n");

		}

		public void shuffleSets()
		{
			removeActiveSets();
			for(int x=0;x<100;x++) //the next two for loops is to shuffle the sets
			{
				getal1 = r.nextInt(abilityList.getAbilityList().size()-1);
				getal2 = r.nextInt(abilityList.getAbilityList().size()-1);

				tempAbility = abilityList.getListElement(getal1+1);

				abilityList.getAbilityList().set(getal1+1, abilityList.getListElement(getal2+1));
				abilityList.getAbilityList().set(getal2+1, tempAbility);
			}
			for(int x=0;x<100;x++)
			{
				getal1 = r.nextInt(raceList.getRaceList().size()-1);
				getal2 = r.nextInt(raceList.getRaceList().size()-1);

				tempRace = raceList.getListElement(getal1+1);

				raceList.getRaceList().set(getal1+1, raceList.getListElement(getal2+1));
				raceList.getRaceList().set(getal2+1, tempRace);
			}
		}

		/*
		 * This method is to change the ability if the player have the Spider Mimes as race
		 *
		 *
		 */
		public void changeAbility()
		{
			int abilityNr = 0;
			if(activePlayer.getActiveSet().getRace().getName().equals(shadowMimes.getName()))
			{
				System.out.println("Do you want change your ability? ");
				scanner = new Scanner(System.in);;

				do
				{
					System.out.println("Say yes or no");
					yesOrNo = scanner.nextLine();
					if(yesOrNo.equals("yes"))
					{
						for(int x=0;x<6;x++) // This for loops shows the first 6 ability's after shuffling.
						{
							System.out.print((x+1) + ": " +  abilityList.getListElement(x).getName());
							System.out.println();
						}
						System.out.println("Choose a new ability: ");
						abilityNr = scanner.nextInt();
						while(abilityNr < 1 || abilityNr > 6 )
						{
							System.out.println("Enter the set number: ");
							abilityNr = scanner.nextInt();
						}
						//this changes the player's ability
						activePlayer.getActiveSet().setAbility(abilityList.getListElement(abilityNr-1));
						System.out.println(activePlayer.getActiveSet().getAbility().getName() + " and " + activePlayer.getActiveSet().getRace().getName() + " for " + activePlayer.getName()  + " is now activated.");

						break;
					}
					if(yesOrNo.equals("no"))
					{
						System.out.println("Continue");
						break;
					}
					System.out.println(yesOrNo);

				}while(!yesOrNo.equals("yes") || !yesOrNo.equals("no"));

			}
			removeActiveSets();
		}

		public void chooseNewSet(Player activePlayer)
		{
			this.activePlayer = activePlayer;

			Set tempSet;
			scanner = new Scanner(System.in);
			System.out.println(activePlayer.getName());
			for(int x=0;x<abilityList.getAbilityList().size();x++) //this removes the race and ability that have the name "Empty"
			{
				if(abilityList.getListElement(x).getName().equals("Empty")){
					abilityList.getAbilityList().remove(x);
				}
			}
			for(int x=0;x<raceList.getRaceList().size();x++)//this removes the race and ability that have the name "Empty"
			{
				if(raceList.getListElement(x).getName().equals("Empty"))
				{
					raceList.getRaceList().remove(x);
				}
			}
			for(int x=0;x<6;x++) // This for loops shows the first 6 sets after shuffling.
			{
				System.out.print((x+1) + ": " +  abilityList.getListElement(x).getName() + " " +  raceList.getListElement(x).getName());
				System.out.println();
			}

			System.out.println("Choose a new set: ");
			try
			{
				setNr = scanner.nextInt();
			}catch(java.util.InputMismatchException e){
				System.out.println(e.getMessage());
			}catch(java.util.NoSuchElementException e){
				System.out.println(e.getMessage());
			}
			while(setNr < 1 || setNr > 6 )
			{
				System.out.println("Enter the set number: ");
				setNr = scanner.nextInt();
			}

			//This make a new set that the player has chosen.
			tempSet = new Set(abilityList.getListElement(setNr-1), raceList.getListElement(setNr-1));

			activePlayer.setActiveSet(tempSet);
			System.out.println(activePlayer.getActiveSet().getAbility().getName() + " and " + activePlayer.getActiveSet().getRace().getName() + " for " + activePlayer.getName()  + " is now activated.");

			if(!activePlayer.getActiveSet().getRace().getName().equals(shadowMimes.getName()))
			{
				removeActiveSets();
			}
		}



		public void removeActiveSets()
		{
			for(int x=0;x<playerList.size();x++) //this removes the active sets
			{
				for(int j=1;j<raceList.getRaceList().size() ;j++)
				{
					if(playerList.get(x).getActiveSet().getRace().getName() == raceList.getListElement(j).getName())
					{
						raceList.getRaceList().remove(j);
					}
				}
				for(int j=1;j<abilityList.getAbilityList().size();j++)
				{
					if(playerList.get(x).getActiveSet().getAbility().getName() == abilityList.getListElement(j).getName())
					{
						abilityList.getAbilityList().remove(j);
					}
				}
			}
		}

}
