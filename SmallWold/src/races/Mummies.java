package races;

import main.Ammy;
import player.Player;

public class Mummies extends Race
{
	public Mummies()
	{
		amountOfTokens = 10;
		maxTokens = 12;
		name = "Mummies";
		traitText = "It takes 1 extra mummy to conquer a region.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}

}
