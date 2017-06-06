package abilities;

import main.Ammy;
import player.Player;

public class Quarreling extends Ability implements CalculatableIncome
{
	public Quarreling()
	{
		amountOfTokens = 3;
		type = "Quarreling";
		traitText = "+1 coin for each seperate region";
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
