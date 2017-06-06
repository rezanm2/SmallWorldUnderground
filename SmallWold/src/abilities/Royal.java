package abilities;

import main.Ammy;
import player.Player;

public class Royal extends Ability
{
	public Royal()
	{
		amountOfTokens = 5;
		type = "Royal";
		traitText = "At the end of turn, place the queen in a region. That becomes immune.";
	}

	@Override
	public void calculateAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}

}
