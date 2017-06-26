package abilities;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
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
	public void processAbility(Player selfPlayer, Map map)
	{
		this.selfPlayer = selfPlayer;
		this.map = map;
		tc.checkTerrainType("Mine", selfPlayer.getActiveSet().getRace());
		abilityIncome = tc.getTerrainStringCounter();
	}


}
