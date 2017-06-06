package abilities;

import player.Player;

public class Wise extends Ability
{
	public Wise()
	{
		amountOfTokens = 4;
		type = "Wise";
		traitText = "+2 coins if any wise tokens are still in play.";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
