package abilities;

import main.Ammy;
import player.Player;

public class Shield extends Ability
{
	public Shield()
	{
		amountOfTokens = 3;
		name = "Shield";
		traitText = "Get a mushroom shield for each shroom region you control";
	}

	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
