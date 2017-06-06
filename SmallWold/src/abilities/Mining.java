package abilities;

import controllers.CombatController;
import main.Ammy;
import player.Player;

public class Mining extends Ability  implements CalculatableIncome
{
	CombatController cc;
	private int abilityIncome;

	public Mining()
	{
		amountOfTokens = 4;
		type = "Mining";
		traitText = "+1 coin for each mine region";
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}

	@Override
	public void calculateAbility(Ammy ammy) {
		this.activePlayer = activePlayer;
		cc.checkTerrainType("Mystic");
		this.setAbilityIncome(cc.getTerrainStringCounter());
	}
}
