package specialPlaces;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;

public class BrassPipe extends SpecialPlace
{
	private Map map;
	private TerrainController terrainController;
	private int terrainNumber;
	private MapTester mapTester;
	private boolean active = true;

	public BrassPipe()
	{
		name = "Great Brass Pipe";
		traitText = "All regions of the same terrain type are considered adjacent";
	}

	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			
			System.out.println(map.getTerrain(terrainNumber).getTerrainName());
			terrainController.checkAdjacentToTerrainType(map.getTerrain(terrainNumber).getTerrainName());
			for(int x=0;x<map.getAllTerrains().size();x++)
			{
				System.out.println(!map.getTerrain(terrainNumber).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName()));
				if(map.getTerrain(x).getIsAdjacent() == true && !map.getTerrain(x).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName()))
				{
					map.getTerrain(x).setIsAttackable(true);//This changes all area adjacent to chasm to attackable
				}
			}
		}
		
	}
}
