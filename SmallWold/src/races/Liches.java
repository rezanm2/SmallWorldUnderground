package races;

import main.Ammy;
import player.Player;

public class Liches extends Race
{
	public Liches()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Liches";
		traitText = "One coin for each conquered decline token";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
