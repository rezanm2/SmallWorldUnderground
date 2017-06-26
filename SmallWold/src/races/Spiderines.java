package races;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import playBoard.Map;
import controllers.TerrainController;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Reza Naser
 */
public class Spiderines extends Race
{
	TerrainController tc;
	Scanner scanner = new Scanner(System.in);
	private int nr;
	private String yesOrNo = "";
	Map map;
	public Spiderines()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Spiderines";
		traitText = "Can attack through Chasms";
	}

	/**
	 * Zorgt ervoor dat het ras kan aanvallen via Chasms.
	 */
	@Override
	public void processAbility(Player selfPlayer, Map map)
	{
		this.selfPlayer = selfPlayer;
		this.map = map;
		tc.checkAdjacentToTerrainType("Chasm");
		//test.whichAreAdjacent();

		for(int x=0;x<map.getTerrains().size();x++)
		{
			if(map.getTerrains().get(x).getIsAdjacent() == true)
			{
				map.getTerrains().get(x).setIsAttackable(true);//This changes all area adjacent to chasm to attackable
			}
		}
		//ammy.setPickRegions(pickRegions);
//		test.whichAreAdjacent();
//		System.out.println("Do you want conquer a terrain adjacent to chasm? ");
//		do
//		{
//			yesOrNo = scanner.nextLine();
//			if(yesOrNo.equals("yes"))
//			{
//				tc.checkAdjacentToTerrainType("Chasm");
//				test.whichAreAdjacent();
//				map.getTerrain(nr).setIsAttackable(true);
//				System.out.println("Choose a terrain nr: ");
//				nr = scanner.nextInt();
//				cc.calculateCombat(map.getAllTerrains().get(nr-1), activePlayer);
//				System.out.println(map.getTerrain(nr-1).getRace().getName());
//				break;
//			}
//			if(yesOrNo.equals("no"))
//			{
//				System.out.println("Continue");
//				break;
//			}
//		}while(yesOrNo.equals("yes") || yesOrNo.equals("no"));
	}
}
