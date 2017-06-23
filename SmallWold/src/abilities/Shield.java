package abilities;

import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Shield extends Ability
{
	public Shield()
	{
		amountOfTokens = 3;
		name = "Shield";
		traitText = "Get a mushroom shield for each shroom region you control";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
