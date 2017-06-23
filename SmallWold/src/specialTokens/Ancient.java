package specialTokens;
import java.util.Scanner;

import controllers.CombatController_old;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

/**
 * Deze klasse houdt de status van deze special Token bij en zijn functionaliteit.
 * @author
 */
public class Ancient extends SpecialToken {
	Map map;
	CombatController_old cc;
	int terrainNumber;
	private Player activePlayer;
	private TerrainController terrainController;
	Scanner scanner = new Scanner(System.in);
	String yesOrNo = "";
	public Ancient()
	{
		name = "Ancient";
	}
	@Override
	public void processSpecialToken(Ammy ammy) {
		this.map = ammy.getMap();
		this.activePlayer = ammy.getActivePlayer();
		this.terrainController = ammy.getTc();
		this.cc = ammy.getCc();

			System.out.println("Do you want replace your Ancient? ");
			yesOrNo = scanner.nextLine();
			if(yesOrNo.equals("y")  || yesOrNo.equals("Y") )
			{
				if(map.getTerrains().get(terrainNumber).getRace().getName().equals("Cultists"))
				{
					System.out.println("On which terrain? ");
					this.terrainNumber = scanner.nextInt()-1;

					terrainController.checkAdjacentToSingleTerrain(map.getTerrains().get(terrainNumber));

					if(map.getTerrains().get(terrainNumber).getIsAdjacent() &&
							map.getTerrains().get(terrainNumber).getSpecialToken().equals(this))
					{
						changeTerrain(terrainNumber);
						cc.setMiscModifier(1);
					}
					for(int x=0;x<map.getTerrains().size();x++)
					{
						System.out.println("Terrain number: " + (x+1) + " is changed to " + map.getTerrains().get(x).getSpecialToken());

					}
					String yesOrNo = "";
				}

			}
			if(yesOrNo.equals("N")  || yesOrNo.equals("n"))
			{
				System.out.println("Continue");
				String yesOrNo = "";
			}

	}
	public void changeTerrain(int terrainNumber) {
		map.getTerrains().get(this.terrainNumber).setIsImmune(false);
		map.getTerrains().get(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrains().get(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;
	}
	public String getName()
	{
		return this.name;
	}
}
