package abilities;

import controllers.CombatController;
import main.Ammy;
import player.Player;

public class Stone extends Ability implements CalculatableIncome
{
	CombatController cc;
	private int abilityIncome;

	public Stone()
	{
		amountOfTokens = 4;
		type = "Stone";
		traitText = "+1 coin for each Stone region";
	}

	@Override
	public void calculateAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		cc.checkTerrainType("Stone");
		this.setAbilityIncome(cc.getTerrainStringCounter());

	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
