package specialPlaces;

import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author
 */
public class MineOfTheLostDwarf extends SpecialPlace implements CalculatableIncome
{
	private int terrainNumber;
	private Map map;
	private int specialPlaceIncome;

	public MineOfTheLostDwarf()
	{
		name = "Mine of the Lost Dwarf";
		traitText = "+2 coins, even in decline";
	}

	/**
	 * Verhoogt de inkomsten van het gebied.
	 */
	@Override
	public void processSpecialPlace(Ammy ammy) {
		setSpecialPlaceIncome(0);
		this.map = ammy.getMap();
		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
			setSpecialPlaceIncome(2);
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
