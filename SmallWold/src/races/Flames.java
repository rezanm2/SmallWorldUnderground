package races;

import controllers.TerrainController;
import main.Ammy;
import player.Player;

public class Flames extends Race
{
	TerrainController terrainController;
	public Flames()
	{
		amountOfTokens = 5;
		maxTokens = 9;
		name = "Flames";
		traitText = "Conquer regions adjacent to volcano as if they were empty.";
	}

	@Override
	public void processAbility(Ammy ammy) {

		this.terrainController = ammy.getTc();

		terrainController.checkTerrainType("Chasm");


	}

}
