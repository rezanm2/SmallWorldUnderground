package abilities;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

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
	}

	@Override
	public void processAbility(Ammy ammy) {
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
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			terrainController.setAllRedeployableAreas(activePlayer);
			mapTester.whichAreRedeployable(activePlayer);
			terrainController.checkIfRedeployable();
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrain(terrainNumber).getIsImmune());
		}
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setIsImmune(false);
		map.getTerrain(terrainNumber).setIsImmune(true);
		this.terrainNumber = terrainNumber;
	}

}
