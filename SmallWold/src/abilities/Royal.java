package abilities;

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
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
