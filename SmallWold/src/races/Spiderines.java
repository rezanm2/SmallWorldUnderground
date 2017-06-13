package races;

import java.util.Scanner;

import main.Ammy;
import player.Player;

public class Spiderines extends Race
{
	Scanner scanner = new Scanner(System.in);
	private int nr;
	public Spiderines()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Spiderines";
		traitText = "Can attack through Chasms";
	}

	@Override
	public void processAbility(Ammy ammy) 
	{
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(activePlayer.getActiveSet().getRace().getName().equals(this.name) && map.getTerrain(x).getTerrainName().equals("Chasm"))
			{
				map.getTerrain(x).setIsImmune(false);
			}
		}
	}
}
