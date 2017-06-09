package races;

import main.Ammy;
import player.Player;

public class Ogres extends Race
{
	public Ogres()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Ogres";
		traitText = "It takes one less token to conquer a region (minimum of one)";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}



}
