package abilities;

import controllers.CombatController;
import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Mining extends Ability  implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;

	public Mining()
	{
		amountOfTokens = 4;
		name = "Mining";
		traitText = "+1 coin for each mine region";
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}

	@Override
	public void processAbility(Player activePlayer) {
		this.activePlayer = activePlayer;
		tc.checkTerrainType("Mystic");
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}
}
