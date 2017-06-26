package abilities;

import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
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
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;

	}
}
