package races;

import controllers.CombatController;
import controllers.TerrainController;
import main.Ammy;
import player.Hand;
import player.Player;
import setup.DeclareCombat;
import setup.RedeployAreas;

public class Mummies extends Race
{
	CombatController cc;
	TerrainController tc;
	RedeployAreas ra;
	DeclareCombat dc;
	int hand;
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
		this.cc = ammy.getCc();
		this.activePlayer = ammy.getActivePlayer();
		
		//This will be repeated in DeclareCombat class
		if(activePlayer.getActiveSet().getRace().getName().equals(this.name))
		{
			cc.setMiscModifier(-1);
		}
	}

}
