 package specialPlaces;

import controllers.MapTester;
import controllers.TerrainController;
import controllers.TokenController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Empty;
import races.Race;

public class WickedestPentacle extends SpecialPlace
{
	private Map map;
	private TerrainController terrainController;
	private MapTester mapTester;
	private int terrainNumber;
	private int terrainOfBalrog;
	private Race losingRace;
	private TokenController tokenController;
	private Player losingPlayer;

	public WickedestPentacle()
	{
		name = "The Wickedest Pentacle";
		traitText = "Move the Balrog. It noms all the shit he goes into, move once per turn.";
	}

	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.mapTester = ammy.getTest();
		this.tokenController = ammy.getToc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getAllTerrains().size(); i++) {
				if(!map.getTerrain(i).getTerrainName().equals("Chasm"))
				map.getTerrain(i).setIsAttackable(true);
			}
			mapTester.whichAreAttackable();
			terrainController.checkIfAttackable();
			changeTerrain(terrainController.getAreaPicked());
			
			losingRace = map.getTerrain(terrainController.getAreaPicked()).getRace();
			tokenController.linkRaceToPlayer(losingRace);
			losingPlayer = tokenController.getRacesPlayer();
			
			losingPlayer.getHand().setCurrentTokens(losingPlayer.getHand().getCurrentTokens() + (map.getTerrain(terrainController.getAreaPicked()).getAmountOfTokens() - 2)); //Calculate loss

			System.out.println("A: " + losingPlayer.getName() + " just lost combat. Now has: " + losingPlayer.getHand().getCurrentTokens()
					+ " in hand, because " + map.getTerrain(terrainController.getAreaPicked()).getAmountOfTokens() + " - 2 were returned to his hand.");
			System.out.println("A: Balrog strikes again");
			map.getTerrain(terrainController.getAreaPicked()).setRace(new Empty());	 							//Make the terrain be the player's Race
			map.getTerrain(terrainController.getAreaPicked()).setAmountOfTokens(0);							  		//The declared amount is set on the terrain
			System.out.println("A: Attack succesful!");
			
			terrainController.setNotAdjacent();
			terrainController.setNotAttackable();
			terrainController.setNotRedeployable();
			terrainController.setAllAttackableAreas(activePlayer);
			terrainController.setAllAdjacentAreas(activePlayer);
			terrainController.setAllRedeployableAreas(activePlayer);
		}
		
	}
	public void changeTerrain (int terrainOfBalrog) {
		map.getTerrain(this.terrainOfBalrog).setIsImmune(false);
		map.getTerrain(terrainOfBalrog).setIsImmune(true);
		this.terrainOfBalrog = terrainNumber;
	}
}
