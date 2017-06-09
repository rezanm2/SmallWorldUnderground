package races;

import main.Ammy;
import player.Player;

public class Monster extends Race
{
	public Monster()
	{
		amountOfTokens = 2;
		maxTokens = 14;
		name = "Monsters";
		traitText = "When conquered, take a special event thingie thing thing";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
}
