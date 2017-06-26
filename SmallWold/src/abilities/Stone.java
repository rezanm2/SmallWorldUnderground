package abilities;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
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

	/**
	 * Checked de hoeveelheid stone-terreinen waar het ras op staat en verhoogd de extra inkomens.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;
		tc.checkTerrainType("Stone", selfPlayer.getActiveSet().getRace());
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
