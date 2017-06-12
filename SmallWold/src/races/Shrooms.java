package races;

import main.Ammy;
import player.Player;

public class Shrooms extends Race implements CalculatableIncome
{
	public Shrooms()
	{
		amountOfTokens = 4;
		maxTokens = 10;
		name = "Shrooms";
		traitText = "+1 coin for each Shroom region";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(map.getTerrain(x).getTerrainName().equals(map.getTerrain(x).getRace().getName()))
			{
				raceIncome++;
				System.out.println("Naam terrein: " + map.getTerrain(x).getTerrainName() + " Naam Race: " + map.getTerrain(x).getRace().getName());

				System.out.println("+1 bonus recieved.");
			}
		}
		
	}

	
	public int getRaceIncome() {
		return raceIncome;
	}
}
