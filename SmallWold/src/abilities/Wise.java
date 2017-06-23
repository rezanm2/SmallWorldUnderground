package abilities;

import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
public class Wise extends Ability implements CalculatableIncome
{
	public Wise()
	{
		amountOfTokens = 4;
		name = "Wise";
		traitText = "+2 coins if any wise tokens are still in play.";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
