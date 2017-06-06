package abilities;

import controllers.CombatController;
import player.Player;

public class Stone extends Ability
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
	public void calculateAbility(Player activePlayer) {
		this.activePlayer = activePlayer;
		cc.checkTerrainType("Mystic");
		this.setAbilityIncome(cc.getTerrainStringCounter());

	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
