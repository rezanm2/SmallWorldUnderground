package races;

import controllers.CombatController_old;
import main.Ammy;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author
 */
public class Ogres extends Race
{
	CombatController_old cc;
	public Ogres()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Ogres";
		traitText = "It takes one less token to conquer a region (minimum of one)";
	}

	/**
	 * Zorgt ervoor dat elk terrein 1 minder kost om over te nemen.
	 */
	@Override
	public void processAbility(Ammy ammy) {

		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.activePlayer = ammy.getActivePlayer();
		cc.setMiscModifier(1);
	}

}
