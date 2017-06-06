package abilities;

import controllers.CombatController;
import player.Player;

public class Muddy extends Ability
{
	CombatController cc;
	private int abilityIncome;

	public Muddy()
	{
		amountOfTokens = 3;
		type = "Flocking";
		traitText = "+1 coin for each mud region";
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
