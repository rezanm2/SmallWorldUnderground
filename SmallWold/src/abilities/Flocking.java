package abilities;

import controllers.CombatController;

public class Flocking extends Ability
{
	public Flocking()
	{
		amountOfTokens = 5;
		type = "Flocking";
		traitText = "+2 coins if all your regions are adjacent.";
	}
}
