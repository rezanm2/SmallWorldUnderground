package abilities;

import java.util.List;

import listCreators.AbilityListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Adventurous extends Ability implements CalculatableIncome
{
	private int abilityIncome;
	private int coins;
	private List<Player> playerList;
	AbilityListCreator abilityList;
	Map map;
	Player activePlayer;
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
	public void processAbility(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	@Override
	public int getAbilityIncome() {
		return 0;
	}
}
