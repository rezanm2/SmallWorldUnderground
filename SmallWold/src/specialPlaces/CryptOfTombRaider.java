package specialPlaces;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;

public class CryptOfTombRaider extends SpecialPlace
{
	private int terrainNumber;
	private int terrainOfGhost;
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
			if(map.getTerrain(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			terrainController.setAllRedeployableAreas(activePlayer);
			mapTester.whichAreRedeployable(activePlayer);
			terrainController.checkIfRedeployable();
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrain(terrainOfGhost).getIsImmune());
		}
		
	}
	
	public void changeTerrain(int terrainOfGhost) {
		map.getTerrain(this.terrainOfGhost).setIsImmune(false);
		map.getTerrain(terrainOfGhost).setIsImmune(true);
		this.terrainOfGhost = terrainNumber;
	}
}
