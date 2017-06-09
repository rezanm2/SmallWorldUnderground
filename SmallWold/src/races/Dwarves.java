package races;

import main.Ammy;
import player.Player;

public class Dwarves extends Race
{
	public Dwarves()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Dwarves";
		traitText = "At end of turn, +1 silver hammer for each mine region.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}

}
