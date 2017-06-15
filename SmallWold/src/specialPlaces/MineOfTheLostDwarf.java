package specialPlaces;

import main.Ammy;
import playBoard.Map;

public class MineOfTheLostDwarf extends SpecialPlace
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
		this.map = ammy.getMap();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		setSpecialPlaceIncome(2);
	}

	public int getSpecialPlaceIncome() {
		return specialPlaceIncome;
	}

	public void setSpecialPlaceIncome(int specialPlaceIncome) {
		this.specialPlaceIncome = specialPlaceIncome;
	}
}
