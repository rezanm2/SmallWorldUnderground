package specialPlaces;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
 */
public class BrassPipe extends SpecialPlace
{
	private Map map;
	private TerrainController terrainController;
	private int terrainNumber;
	private boolean active = true;

	public BrassPipe()
	{
		name = "Great Brass Pipe";
		traitText = "All regions of the same terrain type are considered adjacent";
	}

	/**
	 * Zorgt ervoor dat elk soortgelijk type terrein adjacent telt
	 */
	@Override
	public void processSpecialPlace(Player selfPlayer, Map map) {
		this.map = map;
		this.selfPlayer = selfPlayer;
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && selfPlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {

			System.out.println(map.getTerrains().get(terrainNumber).getTerrainName());
			terrainController.checkAdjacentToTerrainType(map.getTerrains().get(terrainNumber).getTerrainName());
			for(int x=0;x<map.getTerrains().size();x++)
			{
				System.out.println(!map.getTerrains().get(terrainNumber).getRace().getName().equals(selfPlayer.getActiveSet().getRace().getName()));
				if(map.getTerrains().get(x).getIsAdjacent() == true && !map.getTerrains().get(x).getRace().getName().equals(selfPlayer.getActiveSet().getRace().getName()))
				{
					map.getTerrains().get(x).setIsAttackable(true);//This changes all area adjacent to chasm to attackable
				}
			}
		}

	}
}
