package races;

import controllers.CombatController_old;
import controllers.TerrainController;
import main.Ammy;
import player.Hand;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author
 */
public class Mummies extends Race
{
	CombatController_old cc;
	TerrainController tc;
	int hand;
	public Mummies()
	{
		amountOfTokens = 10;
		maxTokens = 12;
		name = "Mummies";
		traitText = "It takes 1 extra mummy to conquer a region.";
	}

	/**
	 * Zorgt ervoor dat elk terrein 1 meer kost om  over te nemen.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.activePlayer = ammy.getActivePlayer();

		//This will be repeated in DeclareCombat class
		if(activePlayer.getActiveSet().getRace().getName().equals(this.name))
		{
			cc.setMiscModifier(-1);
		}
	}

}
