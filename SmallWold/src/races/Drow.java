package races;

import player.Player;

public class Drow extends Race
{

	public Drow()
	{
		amountOfTokens = 4;
		maxTokens = 9;
		name = "Drow    ";
		traitText = "+1 Coin for each terrain that isn't sharing borders with non-drow.";
	}

	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
