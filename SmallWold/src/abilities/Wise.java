package abilities;

import main.Ammy;
import player.Player;

public class Wise extends Ability implements CalculatableIncome
{
	public Wise()
	{
		amountOfTokens = 4;
		type = "Wise";
		traitText = "+2 coins if any wise tokens are still in play.";
	}

	@Override
	public void calculateAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
