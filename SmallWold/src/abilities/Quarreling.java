package abilities;

import player.Player;

public class Quarreling extends Ability
{
	public Quarreling()
	{
		amountOfTokens = 3;
		type = "Quarreling";
		traitText = "+1 coin for each seperate region";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
