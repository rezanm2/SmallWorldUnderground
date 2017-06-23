package abilities;

import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
public class Frightened extends Ability implements CalculatableIncome {
	Map map;

	public Frightened()
	{
		amountOfTokens = 4;
		name = "Frightened";
		traitText = "+1 coin for each region that has 3 or more tokens on it.";
	}

	/**
	 * Checked of er meer dan 3 tokens liggen op 1 terrein en verhoogd de extra inkomsten.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		abilityIncome = 0;

		for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrains().get(terrainCounter).getRace()) &&
					map.getTerrains().get(terrainCounter).getAmountOfTokens() >= 3)
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
