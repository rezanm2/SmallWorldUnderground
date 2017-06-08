package abilities;

import main.Ammy;
import player.Player;

public class Thieving extends Ability implements CalculatableIncome
{
	public Thieving()
	{
		amountOfTokens = 4;
		name = "Thieving";
		traitText = "Steal 1 coin from each adjacent active race";
	}

	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
