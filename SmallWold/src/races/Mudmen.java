package races;

import main.Ammy;
import player.Player;

public class Mudmen extends Race
{
	public Mudmen()
	{
		amountOfTokens = 5;
		maxTokens = 12;
		name = "Mudmen";
		traitText = "Get a new mudmen token at the start of Conquest for each mud region.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}

}
