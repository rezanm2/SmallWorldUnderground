package races;

import main.Ammy;
import main.Decline;
import player.Player;

public class ShadowMimes extends Race
{
	public ShadowMimes()
	{

		amountOfTokens = 7;
		maxTokens = 12;
		name = "Shadow Mimes";
		traitText = "Swap the current special power with a different one while picking this race.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// Integrated in Decline class, method chooseNewSet()
	}
	public String getName()
	{
		return this.name;
	}

}
