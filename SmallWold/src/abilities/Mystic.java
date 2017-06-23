package abilities;


import controllers.TerrainController;
import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
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
		declineTraitText = traitText;
	}

	/**
	 * Checked op hoeveel mystic-terreinen het ras staat en verhoogd de extra inkomsten.
	 */
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
