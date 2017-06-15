package races;

import main.Ammy;
import player.Hand;
import player.Player;

public class Dwarves extends Race
{
	public Dwarves()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Dwarves";
		traitText = "At end of turn, +1 silver hammer for each mine region.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(map.getTerrain(x).getRace().getName().equals(this.name)
					&& map.getTerrain(x).getTerrainName().equals("Mine"))
			{
				activePlayer.getHand().setSilverHammers(activePlayer.getHand().getSilverHammers() + 1);
			}
		}
	}
		
}
