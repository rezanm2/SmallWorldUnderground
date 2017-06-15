package specialPlaces;

import main.Ammy;
import playBoard.Map;

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

	@Override
	public void processSpecialPlace(Ammy ammy) {
		this.map = ammy.getMap();
		setSpecialPlaceIncome(0);
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getSpecialPlace().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		map.getTerrain(terrainNumber).setDefense(1);
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
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
