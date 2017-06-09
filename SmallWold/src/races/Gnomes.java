package races;

import main.Ammy;
import player.Player;

public class Gnomes extends Race
{
	public Gnomes()
	{
		amountOfTokens = 6;
		maxTokens = 11;
		name = "Gnomes";
		traitText = "Can't be targeted by any effects";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}

}
