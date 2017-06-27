package abilities;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever, Bas Dorresteijn
 */
public class Royal extends Ability
{
	private int terrainNumber;
	private Map map;
	private TerrainController terrainController;

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
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;

		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(selfPlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			terrainController.allRedeployableAreas(selfPlayer.getActiveSet().getRace());
			changeTerrain(terrainController.getAreaPicked());

		}
	}

	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setIsImmune(false);
		map.getTerrains().get(terrainNumber).setIsImmune(true);
		this.terrainNumber = terrainNumber;
	}

}
