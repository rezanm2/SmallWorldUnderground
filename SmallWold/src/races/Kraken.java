package races;

import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Kraken extends Race
{
	private int abilityIncome;
	Player activePlayer;
	TerrainController tc;

	public Kraken()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Kraken";
		traitText = "Do not empty river regions at end of turn, even in decline.";
		declineTraitText = traitText;
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		tc.checkTerrainType("River", activePlayer);
		this.setAbilityIncome(tc.getTerrainStringCounter());

	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
