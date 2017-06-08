package abilities;

import main.Ammy;
import player.Player;

public class Frightened extends Ability implements CalculatableIncome
{
	public Frightened()
	{
		amountOfTokens = 4;
		name = "Frightened";
		traitText = "+1 coin for each region that has 3 or more tokens on it.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
