package races;

import controllers.CombatController;
import main.Ammy;
import player.Player;

public class Mummies extends Race
{
	CombatController cc;
	public Mummies()
	{
		amountOfTokens = 10;
		maxTokens = 12;
		name = "Mummies";
		traitText = "It takes 1 extra mummy to conquer a region.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.cc = ammy.getCc();
		if(activePlayer.getActiveSet().getRace().getName().equals(this.name))
		{
			cc.setMiscModifier(-1);
		}
	}

}
