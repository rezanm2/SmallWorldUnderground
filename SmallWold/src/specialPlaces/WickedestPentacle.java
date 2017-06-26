 package specialPlaces;

import controllers.TerrainController;
import controllers.TokenController;
import main.Ammy;
import playBoard.Map;
import player.Player;
import races.Empty;
import races.Race;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
 */
public class WickedestPentacle extends SpecialPlace
{
	private Map map;
	private TerrainController terrainController;
	private int terrainNumber;
	private int terrainOfBalrog;
	private Race losingRace;
	private TokenController tokenController;
	private Player losingPlayer;

	public WickedestPentacle()
	{
		name = "The Wickedest Pentacle";
		traitText = "Move the Balrog. It noms all the shit he occupies.";
	}

	/**
	 * Beweegt de balrog en verwerkt combat.
	 */
	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.tokenController = ammy.getToc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			for(int i = 0; i < map.getTerrains().size(); i++) {
				if(!map.getTerrains().get(i).getTerrainName().equals("Chasm"))
				map.getTerrains().get(i).setIsAttackable(true);
			}
			changeTerrain(terrainController.getAreaPicked());

			losingRace = map.getTerrains().get(terrainController.getAreaPicked()).getRace();
			tokenController.linkRaceToPlayer(losingRace);
			losingPlayer = tokenController.getRacesPlayer();

			losingPlayer.getHand().setCurrentTokens(losingPlayer.getHand().getCurrentTokens() + (map.getTerrains().get(terrainController.getAreaPicked()).getAmountOfTokens() - 2)); //Calculate loss


			System.out.println("A: Balrog strikes again");
			map.getTerrains().get(terrainController.getAreaPicked()).setRace(new Empty());	 							//Make the terrain be the player's Race
			map.getTerrains().get(terrainController.getAreaPicked()).setAmountOfTokens(0);							  		//The declared amount is set on the terrain
			System.out.println("A: Attack succesful!");

			terrainController.setNotAdjacent();
			terrainController.setNotAttackable();
			terrainController.setNotRedeployable();
			terrainController.allAttackableAreas(activePlayer.getActiveSet().getRace());
			terrainController.allAdjacentAreas(activePlayer.getActiveSet().getRace());
			terrainController.allRedeployableAreas(activePlayer.getActiveSet().getRace());
		}

	}
	public void changeTerrain (int terrainOfBalrog) {
		map.getTerrains().get(this.terrainOfBalrog).setIsImmune(false);
		map.getTerrains().get(terrainOfBalrog).setIsImmune(true);
		this.terrainOfBalrog = terrainNumber;
	}
}
