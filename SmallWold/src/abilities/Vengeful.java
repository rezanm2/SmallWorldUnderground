package abilities;

import main.Ammy;
import player.Player;

public class Vengeful extends Ability
{
	public Vengeful()
	{
		amountOfTokens = 4;
		name = "Vengeful";
		traitText = "Give a vengeful token to any player attacking you. Conquer that player's region with 1 less (minimum 1)";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
