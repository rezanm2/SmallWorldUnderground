package abilities;

import player.Player;

public class Immortal extends Ability
{
	public Immortal()
	{
		amountOfTokens = 4;
		type = "Immortal";
		traitText = "Keep all conquered tokens in your hand to redeploy at the end of the turn.";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
