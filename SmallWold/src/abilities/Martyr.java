package abilities;

import main.Ammy;
import player.Player;

public class Martyr extends Ability implements CalculatableIncome
{
	public Martyr()
	{
		amountOfTokens = 5;
		name = "Martyr";
		traitText = "+1 coin every time this race is conquered";
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
