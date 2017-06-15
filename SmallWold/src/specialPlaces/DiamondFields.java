package specialPlaces;

import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;

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

	@Override
	public void processSpecialPlace(Ammy ammy) {
		specialPlaceIncome = 0;
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		for(int i = 0; i < map.getAllTerrains().size(); i++) {
			if(map.getTerrain(i).getRelic().getName() == name)
			{
				terrainNumber = i;
				break;
			}
		}
		if(active == true && activePlayer.getActiveSet().getRace().getName() == map.getTerrain(terrainNumber).getRace().getName()) {
			
			terrainController.checkTerrainType(map.getTerrain(terrainNumber).getTerrainName(), activePlayer);
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
