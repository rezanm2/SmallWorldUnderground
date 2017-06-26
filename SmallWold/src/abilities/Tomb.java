package abilities;

import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
public class Tomb extends Ability
{
	public Tomb()
	{
		amountOfTokens = 5;
		name = "Tomb";
		traitText = "Redeploy once more before going in decline, then keep all tokens. At end of turn, if your tokens were conquered, redeploy them.";
		declineTraitText = traitText;
	}
	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
