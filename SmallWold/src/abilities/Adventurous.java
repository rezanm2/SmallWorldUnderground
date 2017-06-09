package abilities;

import java.util.List;

import controllers.TerrainController;
import listCreators.AbilityListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Adventurous extends Ability implements CalculatableIncome
{
	TerrainController tc;

	public Adventurous()
	{
		amountOfTokens = 5;
		name = "Adventurous";
		traitText = "+1 coin for each popular place";
	}

	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();

	}

	@Override
	public int getAbilityIncome() {
		return 0;
	}
}
