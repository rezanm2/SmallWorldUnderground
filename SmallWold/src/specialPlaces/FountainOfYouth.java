package specialPlaces;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;

public class FountainOfYouth extends SpecialPlace
{
	private Map map;
	private int terrainNumber;
	private int playerTerrainAmount = 0;

	public FountainOfYouth()
	{
		name = "Fountain of Youth";
		traitText = "At the start of turn, receive one bonus token";
	}

	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			playerTerrainAmount = 0;
			System.out.println("iets van spam");
			System.out.println(activePlayer.getActiveSet().getRace().getMaxTokens());
			System.out.println(activePlayer.getHand().getCurrentTokens());
			for(int terrainCounter = 0; terrainCounter < map.getAllTerrains().size(); terrainCounter++) 
			{
				if(map.getTerrain(terrainCounter).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName())) {
					playerTerrainAmount++;
				}
			}
			
			if(activePlayer.getActiveSet().getRace().getMaxTokens() - playerTerrainAmount >= activePlayer.getHand().getCurrentTokens() + 1) {
				activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + 1);
			}
			System.out.println(activePlayer.getHand().getCurrentTokens());
		}
	}
}
