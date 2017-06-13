package races;

import java.util.Scanner;

import listCreators.AbilityListCreator;
import main.Ammy;
import main.Decline;
import player.Player;

public class ShadowMimes extends Race
{
	Decline decline;
	private Scanner scanner;
	String yesOrNo = "";
	AbilityListCreator abilityList;
	private int abilityNr;
	public ShadowMimes()
	{

		amountOfTokens = 7;
		maxTokens = 12;
		name = "Shadow Mimes";
		traitText = "Swap the current special power with a different one while picking this race.";
	}
	public String getName(){
		return this.name;
	}
	@Override
	public void processAbility(Ammy ammy) 
	{
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		this.decline = ammy.getDecline();
		decline.changeAbility();
	}
}
