package abilities;

import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
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
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;
	}

	@Override
	public int getAbilityIncome()
	{
		return abilityIncome;
	}
}
