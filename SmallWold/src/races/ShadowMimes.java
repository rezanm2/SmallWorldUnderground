package races;

import java.util.Scanner;

import listCreators.AbilityListCreator;
import main.Ammy;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author
 */
public class ShadowMimes extends Race
{
	private Scanner scanner;
	String yesOrNo = "";
	AbilityListCreator abilityList;
	private int abilityNr;
	public ShadowMimes()
	{

		amountOfTokens = 7;
		maxTokens = 12;
		name = "ShadowMimes";
		traitText = "Swap the current special power with a different one while picking this race.";
	}
	public String getName(){
		return this.name;
	}

	/**
	 * Veranderd de ability die aan Shadow Mimes gelinked is met een andere ability.
	 */
	@Override
	public void processAbility(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
	}
}
