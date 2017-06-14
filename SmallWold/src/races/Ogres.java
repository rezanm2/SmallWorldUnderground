package races;

import controllers.CombatController;
import main.Ammy;
import player.Player;

public class Ogres extends Race
{
	CombatController cc;
	int terrainNumber;
	boolean active = false;
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
		this.activePlayer = ammy.getActivePlayer();
		cc.setMiscModifier(1);
		
	}



}
