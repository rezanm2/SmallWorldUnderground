package specialTokens;
import java.util.Scanner;

import controllers.CombatController_old;
import controllers.MapTester;
import controllers.TerrainController;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Ancient extends SpecialToken {
	Map map;
	MapTester mapTester;
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
		this.mapTester = ammy.getTest();
		this.cc = ammy.getCc();
		
			System.out.println("Do you want replace your Ancient? ");
			yesOrNo = scanner.nextLine();
			if(yesOrNo.equals("y")  || yesOrNo.equals("Y") )
			{
				if(map.getTerrain(terrainNumber).getRace().getName().equals("Cultists"))
				{
					System.out.println("On which terrain? ");
					this.terrainNumber = scanner.nextInt()-1;
					
					terrainController.checkAdjacentToSingleTerrain(map.getTerrain(terrainNumber));
					
					if(map.getTerrain(terrainNumber).getIsAdjacent() && 
							map.getTerrain(terrainNumber).getSpecialToken().equals(this))
					{
						changeTerrain(terrainNumber);
						cc.setMiscModifier(1);
					}
					for(int x=0;x<map.getAllTerrains().size();x++)
					{
						System.out.println("Terrain number: " + (x+1) + " is changed to " + map.getTerrain(x).getSpecialToken());

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
		map.getTerrain(this.terrainNumber).setIsImmune(false);
		map.getTerrain(this.terrainNumber).setSpecialToken(new Empty());
		map.getTerrain(terrainNumber).setSpecialToken(this);
		this.terrainNumber = terrainNumber;
	}
	public String getName()
	{
		return this.name;
	}
}
