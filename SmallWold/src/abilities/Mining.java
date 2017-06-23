package abilities;

import controllers.CombatController_old;
import controllers.TerrainController;
import main.Ammy;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Mining extends Ability  implements CalculatableIncome
{
	TerrainController tc;
	private int abilityIncome;

	public Mining()
	{
		amountOfTokens = 4;
		name = "Mining";
		traitText = "+1 coin for each mine region";
	}

	/**
	 * Checked op hoeveel Mines het ras staat en verhoogd de inkomsten.
	 */
	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		tc.checkTerrainType("Mine", activePlayer);
		abilityIncome = tc.getTerrainStringCounter();
	}


}
