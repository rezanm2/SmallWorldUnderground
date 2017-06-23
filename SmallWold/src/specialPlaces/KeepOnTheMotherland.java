package specialPlaces;

import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author
 */
public class KeepOnTheMotherland extends SpecialPlace implements CalculatableIncome
{

	private Map map;
	private int terrainNumber;
	private int specialPlaceIncome;

	public KeepOnTheMotherland()
	{
		name = "Keep on the Motherland";
		traitText = "+1 Coin, +1 defense, even when in decline.";
	}

	/**
	 * Verhoogt de extra inkomsten en verdediging van het gebied.
	 */
	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		setSpecialPlaceIncome(0);
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		map.getTerrains().get(terrainNumber).setDefense(1);
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			setSpecialPlaceIncome(1);
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
