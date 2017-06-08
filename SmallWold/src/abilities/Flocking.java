package abilities;

import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Flocking extends Ability implements CalculatableIncome
{
	TerrainController tc;


	public Flocking()
	{
		amountOfTokens = 5;
		name = "Flocking";
		traitText = "+2 coins if all your regions are adjacent.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();


	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return abilityIncome;
	}
}
