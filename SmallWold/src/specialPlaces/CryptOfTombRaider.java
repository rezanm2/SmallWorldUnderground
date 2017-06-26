package specialPlaces;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
 */
public class CryptOfTombRaider extends SpecialPlace
{
	private int terrainNumber;
	private int terrainOfGhost;
	private TerrainController terrainController;
	private Map map;

	public CryptOfTombRaider()
	{
		name = "Crypt of the Tomb Raider";
		traitText = "At end of turn, place ghost in a region. That region is immune.";
	}

	/**
	 * Plaatst de geest op een terrein en maakt dat terrein immuun.
	 */
	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getTerrains().size(); i++) {
				if(!map.getTerrains().get(i).getTerrainName().equals("Chasm") && !(i == terrainNumber))
				map.getTerrains().get(i).setIsAttackable(true);
			}
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrains().get(terrainOfGhost).getIsImmune());

			terrainController.setNotAdjacent();
			terrainController.setNotAttackable();
			terrainController.setNotRedeployable();
			terrainController.setAllAttackableAreas(activePlayer);
			terrainController.setAllAdjacentAreas(activePlayer);
			terrainController.setAllRedeployableAreas(activePlayer);
		}

	}

	public void changeTerrain(int terrainOfGhost) {
		map.getTerrains().get(this.terrainOfGhost).setIsImmune(false);
		map.getTerrains().get(terrainOfGhost).setIsImmune(true);
		this.terrainOfGhost = terrainNumber;
	}
}
