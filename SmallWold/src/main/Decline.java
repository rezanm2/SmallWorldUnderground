package main;
import java.util.Scanner;

import javafx.scene.control.Button;
import listCreators.AbilityListCreator;
import listCreators.RaceListCreator;
import listCreators.RelicListCreator;
import player.Player;

public  class Decline {
		Player activePlayer;
		AbilityListCreator abilityList;
		RaceListCreator raceList;
		Button btnDecline;
	
		public Decline(Ammy ammy){
			
			this.activePlayer = ammy.getActivePlayer();
			this.abilityList = ammy.getAbilityList();
			this.raceList = ammy.getRaceList();
		}
		public void goInDecline(){
	
			System.out.println("Do you want to set your race and ability to decline?");
			Scanner scanner = new Scanner(System.in);
			String yesOrNo = scanner.nextLine();
			while( yesOrNo != "yes" || yesOrNo != "no")
			{
				System.out.print("Say yes or no");
				yesOrNo = scanner.nextLine();
			}
			scanner.close();
			if(yesOrNo == "yes"){
				//with button:
				//btnDecline.setOnAction(e -> 
				//{
				 activePlayer.setDeclineSet(activePlayer.getActiveSet());
			//	});
			}
			if(yesOrNo == "no")
			{
				System.out.println("Continue");
			}
		}
		
		
}
