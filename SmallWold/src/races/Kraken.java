package races;

import main.Ammy;
import player.Player;

public class Kraken extends Race
{
	public Kraken()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Kraken";
		traitText = "Do not empty river regions at end of turn, even in decline.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}

}
