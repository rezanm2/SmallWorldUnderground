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
		this.cc = ammy.getCc();
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(activePlayer.getActiveSet().getRace().getName().equals(this.name))
			{
				cc.setMiscModifier(1);
			}
		}
		
		
	}



}
