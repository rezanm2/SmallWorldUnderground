package races;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Marinus van den Oever
 */
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

	/**
	 * Checked op hoeveel rivierterreinen het ras staat en berekent de extra inkomsten.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;
		tc.checkTerrainType("River", activePlayer.getActiveSet().getRace());
		this.setAbilityIncome(tc.getTerrainStringCounter());

	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
