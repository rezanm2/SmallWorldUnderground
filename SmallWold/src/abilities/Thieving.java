package abilities;

import player.Player;

public class Thieving extends Ability
{
	public Thieving()
	{
		amountOfTokens = 4;
		type = "Thieving";
		traitText = "Steal 1 coin from each adjacent active race";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
