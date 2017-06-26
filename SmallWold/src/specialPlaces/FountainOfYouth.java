package specialPlaces;

import controllers.TerrainController;
import playBoard.Map;
import player.Player;
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
	public void processSpecialPlace(Player selfPlayer, Map map) {
		this.map = map;
		this.selfPlayer = selfPlayer;
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(selfPlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			playerTerrainAmount = 0;
			System.out.println(selfPlayer.getActiveSet().getRace().getMaxTokens());
			System.out.println(selfPlayer.getHand().getCurrentTokens());
			for(int terrainCounter = 0; terrainCounter < map.getTerrains().size(); terrainCounter++)
			{
				if(map.getTerrains().get(terrainCounter).getRace().getName().equals(selfPlayer.getActiveSet().getRace().getName())) {
					playerTerrainAmount++;
				}
			}

			if(selfPlayer.getActiveSet().getRace().getMaxTokens() - playerTerrainAmount >= selfPlayer.getHand().getCurrentTokens() + 1) {
				selfPlayer.getHand().setCurrentTokens(selfPlayer.getHand().getCurrentTokens() + 1);
			}
			System.out.println(selfPlayer.getHand().getCurrentTokens());
		}
	}
}
