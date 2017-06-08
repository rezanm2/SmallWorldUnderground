package abilities;

import main.Ammy;
import player.Player;

public class Immortal extends Ability
{
	public Immortal()
	{
		amountOfTokens = 4;
		name = "Immortal";
		traitText = "Keep all conquered tokens in your hand to redeploy at the end of the turn.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}
}
