package races;

import java.util.Scanner;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;
import terrain.Volcano;

public class Flames extends Race
{
	TerrainController terrainController;
	Scanner scanner = new Scanner(System.in);
	int input;
	Map map;

	public Flames()
	{
		amountOfTokens = 5;
		maxTokens = 9;
		name = "Flames";
		traitText = "Conquer regions adjacent to volcano as if they were empty.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.map = ammy.getMap();
		
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			System.out.println((x+1) + " " + map.getTerrain(x).getTerrainName());
		}
		input = scanner.nextInt();
		map.setTerrain(new Volcano(map.getTerrain(input-1).getIdArray()), (input-1));	
		terrainController.checkAdjacentToTerrainType("Vulcano");
		
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(map.getTerrain(x).getIsAdjacent() == true
					&& map.getTerrain(x).getRace().getName().equals("Empty "))
			{
				map.getTerrain(x).setIsAttackable(true);
			}
			System.out.println(map.getTerrain(x).getIsAttackable());
		}
		
//		for(int i = 0; i < terrainController.getTerrainslist().size(); i++)
//		{
//			System.out.println((terrainController.getTerrainslist().get(i)) + 1);
//		}
//
//		input = scanner.nextInt();
//		for(int i = 0; i < terrainController.getTerrainslist().size(); i++)
//		{
//			if (input ==  (terrainController.getTerrainslist().get(i)) + 1){
//				map.setTerrain(new Volcano(map.getTerrain(terrainController.getTerrainslist().get(i)).getIdArray()), terrainController.getTerrainslist().get(i));
//			}
//
//
//		}

	}

}
