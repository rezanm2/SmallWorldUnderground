package races;

import player.Player;

public class WillOWisp extends Race
{
	public WillOWisp()
	{
		amountOfTokens = 6;
		maxTokens = 11;
		name = "Will-o-Wisp";
		traitText = "Can roll the conquest die infinitely when adjacent to or on mystic regions";
	}

	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
