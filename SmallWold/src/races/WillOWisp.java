package races;

import main.Ammy;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Jeroen Zandvliet
 */
public class WillOWisp extends Race
{
	public WillOWisp()
	{
		amountOfTokens = 6;
		maxTokens = 11;
		name = "WillOWisp";
		traitText = "Can roll the conquest die infinitely when adjacent to or on mystic regions";
	}

	@Override
	public void processAbility(Ammy ammy) {
		// TODO Auto-generated method stub

	}

}
