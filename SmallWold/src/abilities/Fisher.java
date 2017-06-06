package abilities;

import main.Ammy;
import player.Player;

public class Fisher extends Ability implements CalculatableIncome
{
	public Fisher()
	{
		amountOfTokens = 4;
		type = "Fisher";
		traitText = "+1 coin for every coastal region";
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
