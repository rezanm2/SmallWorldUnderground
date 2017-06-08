package abilities;

import java.util.List;

import listCreators.AbilityListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Adventurous extends Ability implements CalculatableIncome
{

	public Adventurous()
	{
		amountOfTokens = 5;
		name = "Adventurous";
		traitText = "+1 coin for each popular place";
	}

	public void calculateAbilityIncome(Player activePlayer){
		this.activePlayer = activePlayer;

	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}

	@Override
	public int getAbilityIncome() {
		return 0;
	}
}
