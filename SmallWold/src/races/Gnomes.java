package races;

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
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
