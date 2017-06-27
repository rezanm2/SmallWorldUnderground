package abilities;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
public class Muddy extends Ability implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;

	public Muddy()
	{
		amountOfTokens = 3;
		name = "Muddy";
		traitText = "+1 coin for each mud region";
		declineTraitText = traitText;
	}

	/**
	 * Checked op hoeveel mud-terreinen het ras staat en verhoogd de extra inkomsten.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;
		tc.checkTerrainType("Mud", selfPlayer.getActiveSet().getRace());
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
