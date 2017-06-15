package specialPlaces;

import main.Ammy;
import playBoard.Map;

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

	@Override
	public void processSpecialPlace(Ammy ammy) {
		setSpecialPlaceIncome(0);
		this.map = ammy.getMap();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
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
