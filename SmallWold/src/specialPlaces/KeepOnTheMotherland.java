package specialPlaces;

import main.Ammy;
import playBoard.Map;

public class KeepOnTheMotherland extends SpecialPlace
{

	private Map map;
	private int terrainNumber;
	private int specialPlaceIncome;

	public KeepOnTheMotherland()
	{
		name = "Keep on the Motherland";
		traitText = "+1 Coin, +1 defense, even when in decline.";
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
		map.getTerrain(terrainNumber).setDefense(1);
		setSpecialPlaceIncome(1);
	}

	public int getSpecialPlaceIncome() {
		return specialPlaceIncome;
	}

	public void setSpecialPlaceIncome(int specialPlaceIncome) {
		this.specialPlaceIncome = specialPlaceIncome;
	}

}
