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

/**
 * Klasse die verantwoordelijk is voor het overnemen en aanvallen van terreinen op het spelbord.
 * Bijzonderheid: deze klasse kan terreinen overnemen waar tegenstanders op staan en ook lege terreinen.
 *
 * @author Marinus
 *
 */

public class CombatController {

	private FieldViewController fieldController;
	private Map map;
	private CombatServiceSkeleton serverCombatService;
	private int declaredTokenAmount;
	private Terrain terrain;
	private int miscModifier;
	private int losingTokens;
	private Race losingRace;

	/**
	 * Ophalen van de speler, het totaal aantal spelers, de FieldViewController en de CombatServiceSkeleton.
	 * Bijzonderheid: de klasse moet kunnen communiceren met de view en de server.
	 * @param selfPlayer
	 * @param playerAmount
	 * @param fieldController
	 * @param serverCombatService
	 *
	 * @author Marinus van den Oever;
	 */
	public CombatController(StackSet stack, Player selfPlayer, int playerAmount, FieldViewController fieldController,
			CombatServiceSkeleton serverCombatService) {
		this.map = new Map(selfPlayer, playerAmount, stack);
		this.fieldController = fieldController;
		fieldController.setCombatController(this);
		this.serverCombatService = serverCombatService;
	}

	/**
	 * Methode die het terrein type print in de console.
	 *
	 * @param terrainId, bijvoorbeeld AA, AB, BB.
	 *
	 * @author Marinus van den Oever, Wim van der Putten
	 */
	public void testTerrain(String terrainId) {

		System.out.println(this.map.getTerrainById(terrainId));

	}

	public void declareTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}

	public Map getMap() {
		return this.map;
	}

	/**
	 * Methode die verantwoordelijk is voor het berekenen of een aanval mogelijk is op het gekozen terrein.
	 * Bijzonderheid: Als de speler niet genoeg fiches heeft zal de dobbelsteen gegooid worden.
	 *
	 * @param terrainId, voor het meegeven welk terrein moet worden aangevallen.
	 * @author Marinus van den Oever, Bas Dorrestein
	 */

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
	/**
	 * Methode is verantwoordelijk voor het uitvoeren van de aanval.
	 * Bijzonderheid: Naast het overnemen en het plaatsen van fiches op een terrein, worden deze ook verrekend.
	 *
	 * @param terrain
	 * @param selfPlayer
	 *
	 * @author Marinus van den Oever, Bas Dorrestein
	 */

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
