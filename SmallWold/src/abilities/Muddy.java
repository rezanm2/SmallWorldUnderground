package abilities;

import controllers.TerrainController;
import main.Ammy;
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
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		tc.checkTerrainType("Mud", activePlayer);
		this.setAbilityIncome(tc.getTerrainStringCounter());
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
