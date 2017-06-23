package abilities;

import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Martyr extends Ability implements CalculatableIncome
{
	public Martyr()
	{
		amountOfTokens = 5;
		name = "Martyr";
		traitText = "+1 coin every time this race is conquered";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}

	@Override
	public int getAbilityIncome()
	{
		return abilityIncome;
	}
}
