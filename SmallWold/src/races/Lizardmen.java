package races;

import main.Ammy;
import player.Player;

public class Lizardmen extends Race
{
	public Lizardmen()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Lizardmen";
		traitText = "Pass through any river without conquering when they're empty";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
}
