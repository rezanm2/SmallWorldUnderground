package races;

import java.util.Scanner;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Vulcano;

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

		this.terrainController = ammy.getTc();
		this.map = ammy.getMap();

		terrainController.checkAdjacentToTerrainType("Chasm");
		for(int i = 0; i < terrainController.getTerrainslist().size(); i++)
		{
			System.out.println((terrainController.getTerrainslist().get(i)) + 1);
		}
		input = scanner.nextInt();
		for(int i = 0; i < terrainController.getTerrainslist().size(); i++)
		{
			if (input ==  (terrainController.getTerrainslist().get(i)) + 1){
				map.setTerrain(new Vulcano(map.getTerrain(terrainController.getTerrainslist().get(i)).getIdArray()), terrainController.getTerrainslist().get(i));
			}
			

		}



	}

}
