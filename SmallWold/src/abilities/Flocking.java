package abilities;

import main.Ammy;
import player.Player;

public class Flocking extends Ability implements CalculatableIncome
{
	public Flocking()
	{
		amountOfTokens = 5;
		type = "Flocking";
		traitText = "+2 coins if all your regions are adjacent.";
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
