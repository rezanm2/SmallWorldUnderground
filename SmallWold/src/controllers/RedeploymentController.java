package controllers;

import playBoard.Map;
import player.Player;
import server.CombatServiceSkeleton;
import server.RedeployServiceSkeleton;
import terrain.Terrain;
import views.fieldView.FieldViewController;
/**
 * Dit de controller voor het redeployen van fiches op de kaart.
 *
 * @author Bas Dorresteijn
 *
 */
public class RedeploymentController {

	private int declaredTokenAmount;
	private Terrain terrain;
	private Map map;
	private FieldViewController fieldController;
	private RedeployServiceSkeleton serverRedeployService;

	/**
	 * Maakt het object van de redeploymentController.
	 * Allereest wordt een map aangemaakt, daarna wordt de fieldController geset.
	 * Dan krijgt de fieldController toegang tot de redeploymentController.
	 * Vervolgens wordt de serverRedeployService geset.
	 *
	 * @param selfPlayer, de speler zelf.
	 * @param playerAmount, het aantal spelers wat het spel speelt.
	 * @param fieldController, de controller van de fieldview.
	 * @param serverRedeployService, de redeployService van de server.
	 */
	public RedeploymentController(Player selfPlayer, int playerAmount,FieldViewController fieldController, RedeployServiceSkeleton serverRedeployService  ){
//		this.map = new Map(selfPlayer, playerAmount);
		this.fieldController =fieldController;
		fieldController.setRedeploymentController(this);
		this.serverRedeployService = serverRedeployService;
	}

	/**
	 * Het zetten van het aantal gedeclareerde tokens.
	 *
	 * @param declaredTokenAmount, het aantal gedeclareerde tokens.
	 */
	public void declareTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}

	/**
	 * Deze methode zorgt ervoor dat een speler kan redeployen op een bepaald terrein.
	 * Als er 0 is gedeclared dan zal het terrein achtergelaten worden en er dus geen tokens geplaatst worden.
	 * Wanneer er een ander aantal gekozen wordt zal eerst gecheckt worden of de speler genoeg tokens in zijn/haar hand heeft, als deze genoeg heeft zal de aanval voortgezet worden.
	 * Vervolgens worden de visuals geupdate.
	 *
	 * @param terrainId, het ID van het terrein, aan de hand hiervan wordt bepaald welk terrein het is.
	 */
	public void doRedeployment(String terrainId) {
		this.terrain = this.map.getTerrainById(terrainId);
		System.out.println(map.getSelfPlayer().getHand().getCurrentTokens());
		if (declaredTokenAmount == 0) {
			System.out.println("Leaving region behind");
			map.getSelfPlayer().getHand().setCurrentTokens(terrain.getAmountOfTokens());
			terrain.setAmountOfTokens(0);
			terrain.setRace(null);
			// @@@@@@ FIX DIE VISUAL WIM WTF IS DEZE
			// @@@@@@ NEED AMOUNT OF TOKEN &&&&&&&& TERRAIN UPDATE
		}
		else if(map.getSelfPlayer().getHand().getCurrentTokens() >= declaredTokenAmount - terrain.getAmountOfTokens()) {
			System.out.println("Setting " + declaredTokenAmount + " on this terrain.");
			map.getSelfPlayer().getHand().setCurrentTokens(map.getSelfPlayer().getHand().getCurrentTokens() + terrain.getAmountOfTokens() - declaredTokenAmount);
			terrain.setAmountOfTokens(declaredTokenAmount);
			// @@@@@@ FIX DIE VISUAL WIM OMG SERVERSHIT MOET HIER GEBEUREN ENZO JAJA
			// @@@@@@ NEED AMOUNT OF TOKEN &&&&&&&& TERRAIN UPDATE
		}
		System.out.println(map.getSelfPlayer().getHand().getCurrentTokens());
	}

}
