package specialPlaces;


import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van de functionaliteit van de specialPlace
 * @author Bas Dorresteijn
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
	public void processSpecialPlace(Player selfPlayer, Map map) {
		setSpecialPlaceIncome(0);
		this.map = map;
		this.selfPlayer = selfPlayer;

		for(int i = 0; i < map.getTerrains().size(); i++) {
			if(map.getTerrains().get(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && selfPlayer.getActiveSet().getRace().getName() == map.getTerrains().get(terrainNumber).getRace().getName()) {
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
