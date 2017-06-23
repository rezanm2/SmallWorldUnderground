package races;

import java.util.Scanner;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;
import terrain.Volcano;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author
 */
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

	/**
	 * Zet de vulkaan op een terrein en zorgt ervoor dat de terreinen eromheen als "leeg" aangevallen kunnen worden.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.map = ammy.getMap();

		for(int x=0;x<map.getTerrains().size();x++)
		{
			System.out.println((x+1) + " " + map.getTerrains().get(x).getTerrainName());
		}
		input = scanner.nextInt();
		map.getTerrains().set((input-1), new Volcano(map.getTerrains().get(input-1).getIdArray()));
		terrainController.checkAdjacentToTerrainType("Vulcano");

		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getIsAdjacent() == true
					&& map.getTerrains().get(x).getRace().getName().equals("Empty "))
			{
				map.getTerrains().get(x).setIsAttackable(true);
			}
			System.out.println(map.getTerrains().get(x).getIsAttackable());
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
