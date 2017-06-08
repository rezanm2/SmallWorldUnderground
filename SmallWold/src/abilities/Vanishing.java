package abilities;

import main.Ammy;
import player.Player;

public class Vanishing extends Ability
{
	public Vanishing()
	{
		amountOfTokens = 5;
		name = "Vanishing";
		traitText = "Remove all tokens when going in decline and get 2 coins for each region";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}
}
