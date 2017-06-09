package abilities;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class Frightened extends Ability implements CalculatableIncome {
	Map map;

	public Frightened()
	{
		amountOfTokens = 4;
		name = "Frightened";
		traitText = "+1 coin for each region that has 3 or more tokens on it.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();

		abilityIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()) &&
					map.getTerrain(terrainCounter).getAmountOfTokens() >= 3)
			{
				abilityIncome++;
			}
		}
	}			// Frightened ability when tokens >= 3, +1 coins

	@Override
	public int getAbilityIncome() {
		return abilityIncome;
	}
}
