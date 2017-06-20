package abilities;

import controllers.CombatController_old;
import controllers.TerrainController;
import main.Ammy;
import player.Player;

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

	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		tc.checkTerrainType("Mine", activePlayer);
		abilityIncome = tc.getTerrainStringCounter();
	}


}
