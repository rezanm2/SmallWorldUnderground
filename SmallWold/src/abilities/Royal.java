package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author
 */
public class Royal extends Ability
{
	private int terrainNumber;
	private Map map;
	private TerrainController terrainController;
	private MapTester mapTester;

	public Royal()
	{
		amountOfTokens = 5;
		name = "Royal";
		traitText = "At the end of turn, place the queen in a region. That becomes immune.";
		declineTraitText = "Queen still immune, but no longer movable.";
	}

	/**
	 * Plaatst de queen in een gebied, die wordt immune.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			terrainController.setAllRedeployableAreas(activePlayer);
			mapTester.whichAreRedeployable(activePlayer);
			terrainController.checkIfRedeployable();
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrains().get(terrainNumber).getIsImmune());
		}
	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setIsImmune(false);
		map.getTerrains().get(terrainNumber).setIsImmune(true);
		this.terrainNumber = terrainNumber;
	}

}
