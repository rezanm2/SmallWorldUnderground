package controllers;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.text.FieldView;

import javafx.application.Platform;
import models.StackSet;
import playBoard.Die;
import playBoard.Map;
import player.Player;
import races.Race;
import server.CombatServiceSkeleton;
import server.ServerTerrain;
import terrain.Terrain;
import views.fieldView.FieldViewController;

public class CombatController {

	private FieldViewController fieldController;
	private Map map;
	private CombatServiceSkeleton serverCombatService;
	private int declaredTokenAmount;
	private Terrain terrain;
	private int miscModifier;
	private int losingTokens;
	private Race losingRace;

	public CombatController(StackSet stack, Player selfPlayer, int playerAmount, FieldViewController fieldController,
			CombatServiceSkeleton serverCombatService) {
		this.map = new Map(selfPlayer, playerAmount, stack);
		this.fieldController = fieldController;
		fieldController.setCombatController(this);
		this.serverCombatService = serverCombatService;
	}

	public void testTerrain(String terrainId) {

		System.out.println(this.map.getTerrainById(terrainId));

	}

	public void declareTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}

	public Map getMap() {
		return this.map;
	}

	public void calculateCombat(String terrainId) throws RemoteException {
		this.terrain = this.map.getTerrainById(terrainId);
		if (terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + miscModifier) { // If
																											// the
																											// player
																											// wins
			doAttack(terrain, map.getSelfPlayer());
		} else {
			// @@@@@@ OPEN SIMPLE DOBBELSTEENSCHERM HIER OFZO OMG MOCHT JE DAT
			// WILLEN MAAR HOEFT NIET
			Die die = map.getDie();
			die.throwDie();
			int result = die.getResult();
			System.out.println("Die: " + die.getResult());
			if (terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + result + miscModifier) {
				doAttack(terrain, map.getSelfPlayer());

			}
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@ END PHASE
		}

		System.out.println("Did shit");
	}

	private void doAttack(Terrain terrain, Player selfPlayer) throws RemoteException {
		System.out.println("Doing attack");
		if (terrain.getRace() == null) { // if terrain is empty
			terrain.setRace(selfPlayer.getActiveSet().getRace()); // @@@@@@@@

			terrain.setAmountOfTokens(declaredTokenAmount); // @@@@@@@@ WIM PLZ
			System.out.println("Attacking null");
			serverCombatService.updateTerrain(terrain.getTerrainId(), selfPlayer.getActiveSet().getRace().getName(),declaredTokenAmount); // sends information to the server
		} else {
			losingTokens = terrain.getRace().getAmountOfTokens();
			losingTokens--;
			losingRace = terrain.getRace();
			terrain.setRace(selfPlayer.getActiveSet().getRace()); // @@@@@@@@
																	// WIM DO
																	// SHIT moet
																	// naar
																	// server
																	// gestuurd
																	// worden
																	// eigenlijk
			terrain.setAmountOfTokens(declaredTokenAmount); // @@@@@@@@ WIM PLZ
			// send loses to server
			// send to server terrain claimed
			System.out.println("Attacking " + terrain.getRace().getName());
		}

		selfPlayer.getHand().setCurrentTokens(selfPlayer.getHand().getCurrentTokens() - declaredTokenAmount);
	}

	public void syncTerrain(ServerTerrain serverTerrain) {

		Terrain editTerrain = this.map.getTerrainById(serverTerrain.getId());

		System.out.println("setting tokens");
		editTerrain.setAmountOfTokens(serverTerrain.getTokens());
		System.out.println("setting race");
		editTerrain.setRace(this.map.getStack().getRaceByName(serverTerrain.getRace()));
		System.out.println("updating view");
		updateFieldView(serverTerrain.getId(), serverTerrain.getRace());
	}
	public void updateFieldView(String id, String raceName){
		Platform.runLater(() -> {
				fieldController.updateFieldById(id,raceName);
		});
	}
}
