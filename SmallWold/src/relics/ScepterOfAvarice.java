package relics;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Deze klasse houdt de functionaliteit van de relic in zich.
 * @author Bas Dorresteijn
 */
public class ScepterOfAvarice extends Relic implements CalculatableIncome{

	private TerrainController terrainController;
	private Map map;
	private int terrainNumber;
	private Player activePlayer;
	private boolean active = true;
	private int relicIncome;

	public ScepterOfAvarice(){

		name = "Scepter of Avarice";
		traitText = "At turn's end, place the Scepter in one of your Regions to double the number"
				+ " of coins you recieve from it(except from other players).";
	}

	/**
	 * Verdubbeld het inkomen van 1 gebied
	 */
	@Override
	public void processRelic(Ammy ammy) {
		this.terrainController = ammy.getTc();
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName())
		{
			terrainController.allRedeployableAreas(activePlayer.getActiveSet().getRace());
			System.out.println(map.getTerrains().get(terrainController.getAreaPicked()).getRelic().getName());
			changeTerrain(terrainController.getAreaPicked());
			System.out.println(map.getTerrains().get(terrainController.getAreaPicked()).getRelic().getName());
			active = false;

			/*
			 * Ergens hier nog n dubbeling uitvoeren.
			 *
			 * Tot die tijd dus
			 */
			setRelicIncome(2);

		}

	}
	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setRelic(new Empty());
		map.getTerrains().get(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}

	@Override
	public int getRelicIncome() {
		return relicIncome;
	}

	public void setRelicIncome(int relicIncome) {
		this.relicIncome = relicIncome;
	}
}
