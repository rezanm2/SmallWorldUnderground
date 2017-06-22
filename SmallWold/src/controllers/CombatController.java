package controllers;

import javax.swing.text.FieldView;

import playBoard.Die;
import playBoard.Map;
import player.Player;
import races.Race;
import server.CombatServiceSkeleton;
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
	public CombatController(Player selfPlayer, int playerAmount,FieldViewController fieldController, CombatServiceSkeleton serverCombatService  ){
		this.map = new Map(selfPlayer, playerAmount);
		this.fieldController =fieldController;
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

	//	this.serverCombatService //wim do shit
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

	public void calculateCombat(String terrainId) {
		this.terrain = this.map.getTerrainById(terrainId);
		if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + miscModifier) {	//If the player wins
			doAttack(terrain, map.getSelfPlayer());
		}
		else {
			// @@@@@@ OPEN SIMPLE DOBBELSTEENSCHERM HIER OFZO OMG MOCHT JE DAT WILLEN MAAR HOEFT NIET
			Die die = map.getDie();
			die.throwDie();
			int result = die.getResult();
			System.out.println("Die: " + die.getResult());
			if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + result + miscModifier) {
				doAttack(terrain, map.getSelfPlayer());
			}
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

	private void doAttack(Terrain terrain, Player selfPlayer) {
		System.out.println("Doing attack");
		if(terrain.getRace() == null) { 							//if terrain is empty
			terrain.setRace(selfPlayer.getActiveSet().getRace());	//@@@@@@@@ WIM DO SHIT moet naar server gestuurd worden eigenlijk
			terrain.setAmountOfTokens(declaredTokenAmount);			//@@@@@@@@ WIM PLZ
			System.out.println("Attacking null");
		}
		else {
			losingTokens = terrain.getRace().getAmountOfTokens();
			losingTokens--;
			losingRace = terrain.getRace();
			terrain.setRace(selfPlayer.getActiveSet().getRace());	//@@@@@@@@ WIM DO SHIT moet naar server gestuurd worden eigenlijk
			terrain.setAmountOfTokens(declaredTokenAmount);			//@@@@@@@@ WIM PLZ
			System.out.println("Attacking " + terrain.getRace().getName());
		}

		selfPlayer.getHand().setCurrentTokens(selfPlayer.getHand().getCurrentTokens() - declaredTokenAmount);
	}

	public void serverUpdateTerrain(Race winningRace, int declaredTokenAmount) {

	}

	public void serverUpdateTerrain(Race winningRace, int declaredTokenAmount, Race losingRace, int losingTokens) {

	}
	//TODO make functions !!



}
