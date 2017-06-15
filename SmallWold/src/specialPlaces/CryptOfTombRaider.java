package specialPlaces;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;

public class CryptOfTombRaider extends SpecialPlace
{
	private int terrainNumber;
	private TerrainController terrainController;
	private Map map;
	private MapTester mapTester;

	public CryptOfTombRaider()
	{
		name = "Crypt of the Tomb Raider";
		traitText = "At the end of turn, put the ghost in a region. That region is immune.";
	}

	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		terrainController.setAllRedeployableAreas(activePlayer);
		mapTester.whichAreRedeployable(activePlayer);
		terrainController.checkIfRedeployable();
		changeTerrain(terrainController.getAreaPicked());
		System.out.println(map.getTerrain(terrainNumber).getIsImmune());
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setIsImmune(false);
		map.getTerrain(terrainNumber).setIsImmune(true);
		this.terrainNumber = terrainNumber;
	}
}
