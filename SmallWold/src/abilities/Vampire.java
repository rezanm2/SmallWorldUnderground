package abilities;

import main.Ammy;
import player.Player;

public class Vampire extends Ability
{
	public Vampire()
	{
		amountOfTokens = 5;
		type = "Vampire";
		traitText = "Replace one single opponent token with one single vampire token. That token is killed, even immortal.";
	}

	@Override
	public void calculateAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
