package abilities;

import controllers.CombatController;
import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Muddy extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;

	public Muddy()
	{
		amountOfTokens = 3;
		name = "Muddy ";
		traitText = "+1 coin for each mud region";
	}	

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		tc.checkTerrainType("Muddy");
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
