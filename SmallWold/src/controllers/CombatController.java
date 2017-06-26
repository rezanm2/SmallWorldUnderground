package controllers;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.text.FieldView;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import models.StackSet;
import playBoard.Die;
import playBoard.Map;
import player.Player;
import races.Drow;
import races.Race;
import server.CombatServiceSkeleton;
import server.ServerTerrain;
import terrain.Terrain;
import views.fieldView.FieldViewController;

/**
 * Klasse die verantwoordelijk is voor het overnemen en aanvallen van terreinen op het spelbord.
 * Bijzonderheid: deze klasse kan terreinen overnemen waar tegenstanders op staan en lege terreinen.
 *
 * @author Bas Dorresteijn, Marinus van den Oever, Reza Naser, Wim van der Putten, Jeroen Zandvliet
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
	private TerrainController terrainController;
	private boolean isValidChoice;


	Drow drow = new Drow();

	/**
	 * Ophalen van de speler, het totaal aantal spelers, de FieldViewController en de CombatServiceSkeleton.
	 * Bijzonderheid: de klasse moet kunnen communiceren met de view en de server.
	 * @param selfPlayer
	 * @param playerAmount
	 * @param fieldController
	 * @param serverCombatService
	 */
	public CombatController(FieldViewController fieldController, CombatServiceSkeleton serverCombatService, Map map) {
		this.fieldController = fieldController;
		fieldController.setCombatController(this);
		this.serverCombatService = serverCombatService;
		this.map = map;
		terrainController = new TerrainController(map);

	}
	/**
	 * Methode die het terrein type print in de console.
	 *
	 * @param terrainId, bijvoorbeeld AA, AB, BB.
	 *
	 *
	 */
	public void testTerrain(String terrainId) {

		System.out.println(this.map.getTerrainById(terrainId));

	}


	public void setBordersToAttackable()
	{
		map.getTerrains().get(0).setIsAttackable(true);
		map.getTerrains().get(1).setIsAttackable(true);
		map.getTerrains().get(2).setIsAttackable(true);
		map.getTerrains().get(3).setIsAttackable(true);
		map.getTerrains().get(4).setIsAttackable(true);
		map.getTerrains().get(5).setIsAttackable(true);
		map.getTerrains().get(16).setIsAttackable(true);
		map.getTerrains().get(23).setIsAttackable(true);
		map.getTerrains().get(27).setIsAttackable(true);
		map.getTerrains().get(26).setIsAttackable(true);
		map.getTerrains().get(25).setIsAttackable(true);
		map.getTerrains().get(24).setIsAttackable(true);
		map.getTerrains().get(17).setIsAttackable(true);
		map.getTerrains().get(6).setIsAttackable(true);
	}



	public void setAllAreas(Player selfPlayer)
	{
		terrainController.setNotAdjacent();
		terrainController.setNotAttackable();
		terrainController.setNotRedeployable();

		terrainController.allAdjacentAreas(selfPlayer.getActiveSet().getRace());
		terrainController.allAttackableAreas(selfPlayer.getActiveSet().getRace());
		terrainController.allRedeployableAreas(selfPlayer.getActiveSet().getRace());
	}

	public void isItAValidChoice(StackPane fieldPane)
	{
		isValidChoice = false;

		terrain = map.getTerrainById(fieldPane.getId());

		if(terrain.getIsAttackable() == true)
		{
			isValidChoice = true;
		}
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
	 * @author Marinus van den Oever, Bas Dorrestein, Wim van der Putten
	 */

	public void calculateCombat(String terrainId) throws RemoteException {
		this.terrain = this.map.getTerrainById(terrainId);

		if (terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + miscModifier)
		{ // If
																											// the
																											// player
																											// wins
			doAttack(terrain, map.getSelfPlayer());
		}
		else if (declaredTokenAmount != 0)
		{
			// @@@@@@ OPEN SIMPLE DOBBELSTEENSCHERM HIER OFZO OMG MOCHT JE DAT
			// WILLEN MAAR HOEFT NIET
			Die die = map.getDie();
			die.throwDie();
			System.out.println("Die: " + die.getResult());
			if (terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + die.getResult() + miscModifier)
			{
				doAttack(terrain, map.getSelfPlayer());
				System.out.println("Die attack was succesful.");
			}
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@ END PHASE
		}

		System.out.println("client: proccesed attacking");
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
			terrain.setRace(selfPlayer.getActiveSet().getRace());
			terrain.setAmountOfTokens(declaredTokenAmount);


			System.out.println("Attacking empty field");
			serverCombatService.updateTerrain(terrain.getTerrainId(), selfPlayer.getActiveSet().getRace().getName(),declaredTokenAmount); // sends information to the server
		} else {
			losingTokens = terrain.getAmountOfTokens();
			losingTokens--;
			losingRace = terrain.getRace();

			terrain.setRace(selfPlayer.getActiveSet().getRace());
			terrain.setAmountOfTokens(declaredTokenAmount);
			// send loses to server
			serverCombatService.updateTerrain(terrain.getTerrainId(), selfPlayer.getActiveSet().getRace().getName(),declaredTokenAmount); // sends information to the server

			serverCombatService.updateLosePlayer(losingRace.getName(),losingTokens );
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
		updateFieldView(serverTerrain.getId(), serverTerrain.getRace(), serverTerrain.getTokens());
	}

	public void updateFieldView(String id, String raceName, int tokens){
		Platform.runLater(() -> {
				fieldController.updateFieldById(id,raceName, tokens);
		});
	}

	public void syncLoses(String name, int losingTokens) {
		if(this.map.getSelfPlayer().getActiveSet().getRace().getName().equals(name)){
			this.map.getSelfPlayer().getHand().setCurrentTokens(this.map.getSelfPlayer().getHand().getCurrentTokens() + losingTokens);

		}

	}
	public boolean isValidChoice() {
		return isValidChoice;
	}
	public void setValidChoice(boolean isValidChoice) {
		this.isValidChoice = isValidChoice;
	}


}
