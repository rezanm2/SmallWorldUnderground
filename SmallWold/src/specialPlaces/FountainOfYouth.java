package specialPlaces;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
 */
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

	/**
	 * Geeft de speler een actieve token van de bank
	 */
	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			playerTerrainAmount = 0;
			System.out.println(activePlayer.getActiveSet().getRace().getMaxTokens());
			System.out.println(activePlayer.getHand().getCurrentTokens());
			for(int terrainCounter = 0; terrainCounter < map.getTerrains().size(); terrainCounter++)
			{
				if(map.getTerrains().get(terrainCounter).getRace().getName().equals(activePlayer.getActiveSet().getRace().getName())) {
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
