package abilities;

import java.util.List;

import controllers.CombatController;
import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Mystic extends Ability  implements CalculatableIncome
{
	private int abilityIncome;
	Player activePlayer;
	TerrainController tc;

	public Mystic()
	{
		amountOfTokens = 4;
		name = "Mystic";
		traitText = "+1 coin for each mystic region";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		tc.checkTerrainType("Mystic", activePlayer);
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}
}
