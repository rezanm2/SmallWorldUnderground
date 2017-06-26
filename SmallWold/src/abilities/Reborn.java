package abilities;

import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
public class Reborn extends Ability
{
	public Reborn()
	{
		amountOfTokens = 5;
		name = "Reborn";
		traitText = "When in decline, can replace 1 or 2 regions with a single new active race token";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Ammy ammy)
	{


	}

}
