package races;

import main.Ammy;
import player.Player;

public class Flames extends Race
{
	public Flames()
	{
		amountOfTokens = 5;
		maxTokens = 9;
		name = "Flames";
		traitText = "Conquer regions adjacent to volcano as if they were empty.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}

}
