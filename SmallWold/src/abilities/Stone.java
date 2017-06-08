package abilities;

import controllers.CombatController;
import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Stone extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;

	public Stone()
	{
		amountOfTokens = 4;
		name = "Stone";
		traitText = "+1 coin for each Stone region";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.tc = ammy.getTc();
		tc.checkTerrainType("Mystic");
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
