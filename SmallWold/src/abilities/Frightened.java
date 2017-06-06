package abilities;

import main.Ammy;
import player.Player;

public class Frightened extends Ability implements CalculatableIncome
{
	public Frightened()
	{
		amountOfTokens = 4;
		type = "Frightened";
		traitText = "+1 coin for each region that has 3 or more tokens on it.";
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
