package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javafx.application.Platform;
import models.StackSet;
import playBoard.Map;
import player.Hand;
import player.Player;
import server.CombatServiceSkeleton;
import server.RedeployServiceSkeleton;
import server.ServerTerrain;
import terrain.Terrain;
import views.fieldView.FieldViewController;
/**
 * Dit de controller voor het redeployen van fiches op de kaart.
 *
 * @author Bas Dorresteijn, Wim van der Putten
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
	public RedeploymentController(FieldViewController fieldViewController, RedeployServiceSkeleton serverRedeployService, Map map) {
		this.map = map;
		this.fieldController = fieldViewController;
		this.fieldController.setRedeploymentController(this);
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
	 * @throws RemoteException
	 */
	public void doRedeployment(String terrainId) throws RemoteException {
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
		serverRedeployService.deployTerrain(terrain.getTerrainId(), declaredTokenAmount); // sends information to the server

		System.out.println(map.getSelfPlayer().getHand().getCurrentTokens());
	}

	public void prepareFields() throws RemoteException {
		ArrayList<Terrain> terrainList = this.map.getTerrainByActiveRace();
		ArrayList<String> updateList = new ArrayList<>();
		for (Terrain terrain : terrainList) {
			if(terrain.getAmountOfTokens() > 1){
				Hand playerHand = this.map.getSelfPlayer().getHand();
				playerHand.setCurrentTokens(playerHand.getCurrentTokens() + (terrain.getAmountOfTokens() - 1));
				updateList.add(terrain.getTerrainId());
			}
		}
		System.out.println("preparing fields, for redeployment/conquest/decline");
		this.serverRedeployService.syncTerrains(updateList);

	}

	public void syncTerrain(ServerTerrain serverTerrain) {

		Terrain editTerrain = this.map.getTerrainById(serverTerrain.getId());
		editTerrain.setAmountOfTokens(serverTerrain.getTokens());
		if(serverTerrain.getTokens() == 0){
			serverTerrain.setRace(null);
		}
		updateFieldView(serverTerrain.getId(), serverTerrain.getRace(), serverTerrain.getTokens());
	}

	public void updateFieldView(String id, String raceName, int tokens){
		Platform.runLater(() -> {
				fieldController.updateFieldById(id,raceName, tokens);
		});
	}

	public void turnthingy(int turn) {
		fieldController.nextTurn(turn);

	}


}
