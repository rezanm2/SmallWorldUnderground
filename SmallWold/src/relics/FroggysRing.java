package relics;

import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Race;

public class FroggysRing extends Relic {
	
	Map map;
	boolean active = true;
	int terrainNumber;
	private TerrainController terrainController;
	private MapTester mapTester;
	private int relicIncome;
	private Player activePlayer;
	private int terrainCounter;
	
	public FroggysRing(){
		
		name = "Froggy's Ring";
		traitText = "At turn's end, place the Ring in 1 of your Regions to collect a bonus coin "
					+ "from each opponent with at least 1 Active race token bordering the Ring";
	}

	@Override
	public void processRelic(Ammy ammy) {
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
			}
		}
		System.out.println("Doing other shit");
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName())
		{
			terrainController.setAllRedeployableAreas(activePlayer);
			mapTester.whichAreRedeployable(activePlayer);
			terrainController.checkIfRedeployable();
			changeTerrain(terrainController.getAreaPicked());
			active = false;
			System.out.println(terrainController.getAreaPicked());
			terrainController.changeAllAdjacentAreas(map.getTerrain(terrainController.getAreaPicked()).getIdArray()[0]);
			System.out.println("Did some shit");
			for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
			{
				System.out.println(activePlayer.getActiveSet().getRace().getName());
				System.out.println(map.getTerrain(terrainCounter).getRace().getName());
				if(map.getTerrain(terrainCounter).getIsAdjacent() == true && !map.getTerrain(terrainCounter).getRace().getName().equals("Empty ")
						&& activePlayer.getActiveSet().getRace().getName().equals(map.getTerrain(terrainCounter).getRace().getName()))						//If isAttackable is true
				{
					System.out.println("A: " + (terrainCounter + 1) + "\t     "
							+ map.getTerrain(terrainCounter).getTerrainName() + "\t"
							+ map.getTerrain(terrainCounter).getRace().getName()
							+ "\t" + map.getTerrain(terrainCounter).getAmountOfTokens());
				}
			}
			/*
			 * Ergens hier nog n thief actie toevoegen
			 */
		}
	}
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}
	
	public int getTerrainNumber() {
		return terrainNumber;
	}

}
