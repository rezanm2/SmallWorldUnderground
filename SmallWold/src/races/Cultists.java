package races;

import java.util.Scanner;

import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import player.Player;
import races.Race;
import specialTokens.Ancient;

public class Cultists extends Race
{
	Ancient an = new Ancient();
	MapTester mapTester;
	TerrainController terrainController;
	CombatController cc;
	
	public Cultists()
	{
		amountOfTokens = 5;
		maxTokens = 10;
		name = "Cultists";
		traitText = "Can place the Great Ancient in the first region, and at the start of the turn. Attack at 1 less around him.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		this.cc = ammy.getCc();
		String yesOrNo = "";
		Scanner scanner = new Scanner(System.in);
		int terrainNumber;
		int counter = 0;
		
		
		if(activePlayer.getActiveSet().getRace().getName().equals(this.name))
		{
			for(int terrainCounter = 0; terrainCounter< map.getAllTerrains().size();terrainCounter++)
			{
				
				if(map.getTerrain(terrainCounter).getSpecialToken().equals(an))
				{
					an.processSpecialToken(ammy);
				}
				else
				{
					counter++;
				}
			}
			if(map.getAllTerrains().size() == counter)
			{
				System.out.println("Do you want place you special token? ");
				yesOrNo = scanner.nextLine();
				if(yesOrNo.equals("y")  || yesOrNo.equals("Y") )
				{
					System.out.println("On which terrain? ");
					terrainNumber = scanner.nextInt()-1;
					map.getTerrain(terrainNumber).setSpecialToken(an);
					terrainController.checkAdjacentToSingleTerrain(map.getTerrain(terrainNumber));
					if(map.getTerrain(terrainNumber).getIsAdjacent() && 
							map.getTerrain(terrainNumber).getSpecialToken() == an)
					{
						cc.setMiscModifier(1);
					}
					for(int x=0;x<map.getAllTerrains().size();x++)
					{
						System.out.println("C: Terrain number: " + (x+1) + " is changed to " + map.getTerrain(x).getSpecialToken());

					}
				}
				if(yesOrNo.equals("N")  || yesOrNo.equals("n"))
				{
					System.out.println("Continue");
				}
			}

		}
	}

}
