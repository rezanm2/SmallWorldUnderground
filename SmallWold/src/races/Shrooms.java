package races;

import main.Ammy;
import player.Player;

public class Shrooms extends Race
{
	public Shrooms()
	{
		amountOfTokens = 4;
		maxTokens = 10;
		name = "Shrooms";
		traitText = "+1 coin for each Shroom region";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
}
