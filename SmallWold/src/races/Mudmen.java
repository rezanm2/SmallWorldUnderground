package races;

import main.Ammy;
import player.Player;

public class Mudmen extends Race
{
	public Mudmen()
	{
		amountOfTokens = 5;
		maxTokens = 12;
		name = "Mudmen";
		traitText = "Get a new mudmen token at the start of Conquest for each mud region.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(map.getTerrain(x).getTerrainName().equals(map.getTerrain(x).getRace().getName()))
			{
				amountOfTokens++;
				System.out.println(amountOfTokens);
			}
		}
		
	}

}
