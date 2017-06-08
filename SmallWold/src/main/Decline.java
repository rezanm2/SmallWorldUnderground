package main;
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
		AbilityListCreator abilityList;
		RaceListCreator raceList;
		List<Player> playerList;
		Ability [] arrAbility = {new Adventurous(), new Fisher(), new Flocking(), new Frightened(), new Immortal(), new Magic(),
				new Martyr(), new Mining(), new Muddy(), new Mystic(), new Quarreling(), new Reborn(), new Royal(), new Shield(), 
				new Stone(), new Thieving(), new Tomb(), new Vampire(), new Vanishing(), new Vengeful(), new Wise()};
		
		Race [] arrRaces = {new Cultists(), new Drow(), new Flames(), new Gnomes(), new Kraken(), new Liches(), new Lizardmen(),
				new Monster(), new Mudmen(), new Mummies(), new Ogres(), new ShadowMimes(), new Shrooms(), new Spiderines(), new WillOWisp()};
		
		 ArrayList<Ability> arrA = new ArrayList<Ability>();
		 ArrayList<Race> arrNewRaces = new ArrayList<Race>();
		
		public Decline(Ammy ammy){
			
			this.activePlayer = ammy.getActivePlayer();
			this.abilityList = ammy.getAbilityList();
			this.raceList = ammy.getRaceList();
			this.playerList = ammy.getPlayerList();
		}
		public void goInDecline(){
	
			System.out.println("Do you want to set your race and ability to decline?");
			Scanner scanner = new Scanner(System.in);
			String yesOrNo = scanner.nextLine();
//			while( !yesOrNo.equals("yes") || !yesOrNo.equals("no"))
//			{
//				System.out.print("Say yes or no");
//				yesOrNo = scanner.nextLine();
//			}
			scanner.close();
			if(yesOrNo.equals("yes")){
				//with button:
				//btnDecline.setOnAction(e -> 
				//{
				 activePlayer.setDeclineSet(activePlayer.getActiveSet());
				 System.out.println(activePlayer.getDeclineSet().getRace().getName() + " and " +activePlayer.getDeclineSet().getAbility().getName() + " for player: " + activePlayer.getName().toString() +  " are declined");
				 //	});
			}
			if(yesOrNo.equals("no"))
			{
				System.out.println("Continue");
			}
		}
		public void shuffleSets(){
			
			Ability ability;
			Race race;
			Random r = new Random();
			for(int x=0;x<100;x++){
				
				int getal = r.nextInt(arrAbility.length);
				int getal2 = r.nextInt(arrAbility.length);
				ability = arrAbility[getal];
				arrAbility[getal] = arrAbility[getal2];
				arrAbility[getal2] = ability;
		}
			for(int x=0;x<100;x++){
				
				int getal = r.nextInt(arrRaces.length);
				int getal2 = r.nextInt(arrRaces.length);
				race = arrRaces[getal];
				arrRaces[getal] = arrRaces[getal2];
				arrRaces[getal2] = race;
		}
			
	}
		public void chooseNewSet(){
			Set tempSet;

			for(int x=0;x<arrAbility.length;x++){
				arrA.add(arrAbility[x]);
			}
			for(int x=0;x<arrRaces.length;x++){
				arrNewRaces.add(arrRaces[x]);
			}
			for(int x=0;x<arrA.size();x++){
				if(playerList.get(0).getActiveSet().getAbility().getName() == arrA.get(x).getName())
				{
					arrA.remove(x);
				}
				if(playerList.get(1).getActiveSet().getAbility().getName() == arrA.get(x).getName())
				{
					arrA.remove(x);
				}
				 if(playerList.size() > 2)
				{
					if(playerList.get(2).getActiveSet().getAbility().getName() == arrA.get(x).getName())
					{
						arrA.remove(x);
					}
						if(playerList.size() > 3)
						{
							if(playerList.get(3).getActiveSet().getAbility().getName() == arrA.get(x).getName())
							{
								arrA.remove(x);
							}
								if(playerList.size() > 4)
								{
									if(playerList.get(4).getActiveSet().getAbility().getName() == arrA.get(x).getName())
									{
										arrA.remove(x);
									}
								}
						}
				}
			}
			for(int x=0;x<arrNewRaces.size();x++){
				if(playerList.get(0).getActiveSet().getRace().getName() == arrNewRaces.get(x).getName())
				{
					arrNewRaces.remove(x);
				}
				if(playerList.get(1).getActiveSet().getRace().getName() == arrNewRaces.get(x).getName())
				{
					arrNewRaces.remove(x);
				}
				if(playerList.size() > 2)
				{
					if(playerList.get(2).getActiveSet().getRace().getName() == arrNewRaces.get(x).getName())
					{
						arrNewRaces.remove(x);
					}
						if(playerList.size() > 3)
						{
							if(playerList.get(3).getActiveSet().getRace().getName() == arrNewRaces.get(x).getName())
							{
								arrNewRaces.remove(x);
							}
							if(playerList.size() > 4 && playerList.size() < 6)
								{
									if(playerList.get(4).getActiveSet().getRace().getName() == arrNewRaces.get(x).getName())
									{
										arrNewRaces.remove(x);
									}
								}
						}
				}
			}
			for(int x=0;x<6;x++){
				System.out.print((x+1) + ": " +  arrA.get(x).getName() + " " +  arrNewRaces.get(x).getName());
				System.out.println();
			}
//			System.out.println(playerList.get(0).getActiveSet().getAbility().getType() + " " + playerList.get(0).getActiveSet().getRace().getTokenType());
//			System.out.println(playerList.get(1).getActiveSet().getAbility().getType() + " " + playerList.get(1).getActiveSet().getRace().getTokenType());
//			System.out.println(playerList.get(2).getActiveSet().getAbility().getType() + " " + playerList.get(2).getActiveSet().getRace().getTokenType());
//			System.out.println(playerList.get(3).getActiveSet().getAbility().getType() + " " + playerList.get(3).getActiveSet().getRace().getTokenType());
//			System.out.println(playerList.get(4).getActiveSet().getAbility().getType() + " " + playerList.get(4).getActiveSet().getRace().getTokenType());
			Scanner input = new Scanner(System.in);
			System.out.println("Choose a new set: ");
			int setNr = input.nextInt();
			
			while(setNr < 1 || setNr > 6){
				System.out.println("Enter the set number: ");
				setNr = input.nextInt();
			}
			tempSet = new Set(arrA.get(setNr-1), arrNewRaces.get(setNr-1));
			activePlayer.setActiveSet(tempSet);

			
			
			System.out.println(playerList.get(0).getActiveSet().getAbility().getName() + " and " + playerList.get(0).getActiveSet().getRace().getName() + " for " + activePlayer.getName()  + " is now activated.");
			System.out.println(arrA.size());
			System.out.println(arrNewRaces.size());

		}
}
