package abilities;

import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Fisher extends Ability implements CalculatableIncome
{
	TerrainController tc;

	public Fisher()
	{
		amountOfTokens = 4;
		name = "Fisher";
		traitText = "+1 coin for every pair of coastal regions";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.tc = ammy.getTc();
		this.activePlayer = ammy.getActivePlayer();


		tc.checkAdjacentToTerrainType("River");

	}

	@Override
	public int getAbilityIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
}
