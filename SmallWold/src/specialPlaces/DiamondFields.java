package specialPlaces;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
 */
public class DiamondFields extends SpecialPlace implements CalculatableIncome
{
	private Map map;
	private TerrainController terrainController;
	private int terrainNumber;
	private boolean active = true;
	private int specialPlaceIncome;

	public DiamondFields()
	{
		name = "Diamond Fields";
		traitText = "+1 Coin for each region that the diamond fields are on";
	}

	/**
	 * Berekend welke terreinen de speler heeft en verhoogd de extra inkomen.
	 */
	@Override
	public void processSpecialPlace(Ammy ammy) {
		specialPlaceIncome = 0;
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {

			terrainController.checkTerrainType(map.getTerrains().get(terrainNumber).getTerrainName(), activePlayer);
			setSpecialPlaceIncome(terrainController.getTerrainStringCounter());
			System.out.println("Income specialPlace " + specialPlaceIncome);
		}
	}

	@Override
	public int getSpecialPlaceIncome() {
		return specialPlaceIncome;
	}

	public void setSpecialPlaceIncome(int specialPlaceIncome) {
		this.specialPlaceIncome = specialPlaceIncome;
	}
}
