package abilities;

import main.Ammy;
import player.Player;

public class Tomb extends Ability
{
	public Tomb()
	{
		amountOfTokens = 5;
		name = "Tomb";
		traitText = "Redeploy once more before going in decline, then keep all tokens. At end of turn, if your tokens were conquered, redeploy them.";
	}
	@Override
	public void processAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
