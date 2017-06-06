package abilities;

import main.Ammy;
import player.Player;

public class Shield extends Ability
{
	public Shield()
	{
		amountOfTokens = 3;
		type = "Shield";
		traitText = "Get a mushroom shield for each shroom region you control";
	}

	@Override
	public void calculateAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
