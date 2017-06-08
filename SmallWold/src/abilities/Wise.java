package abilities;

import main.Ammy;
import player.Player;

public class Wise extends Ability implements CalculatableIncome
{
	public Wise()
	{
		amountOfTokens = 4;
		name = "Wise";
		traitText = "+2 coins if any wise tokens are still in play.";
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
