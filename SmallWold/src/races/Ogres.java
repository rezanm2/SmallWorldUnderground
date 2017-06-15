package races;

import controllers.CombatController;
import main.Ammy;
import player.Player;

public class Ogres extends Race
{
	CombatController cc;
	public Ogres()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Ogres";
		traitText = "It takes one less token to conquer a region (minimum of one)";
	}

	@Override
	public void processAbility(Ammy ammy) {
		
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.activePlayer = ammy.getActivePlayer();
		
		//This will be repeated in DeclareCombat class
		if(activePlayer.getActiveSet().getRace().getName().equals(this.name))
		{
			cc.setMiscModifier(1);
		}
	}

}
