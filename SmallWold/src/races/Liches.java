package races;

import player.Player;

public class Liches extends Race
{
	public Liches()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Liches";
		traitText = "Receive one coin from any player attacking Liches";
	}

	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
