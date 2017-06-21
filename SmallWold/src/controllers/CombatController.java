package controllers;

import javax.swing.text.FieldView;

import playBoard.Die;
import playBoard.Map;
import player.Player;
import races.Race;
import server.CombatServiceSkeleton;
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

	public CombatController(Player selfPlayer, int playerAmount,FieldViewController fieldController, CombatServiceSkeleton serverCombatService  ){
		this.map = new Map(selfPlayer, playerAmount);
		this.fieldController =fieldController;
		fieldController.setCombatController(this);
		this.serverCombatService = serverCombatService;
	}

	public void testTerrain(String terrainId) {

		System.out.println(this.map.getTerrainById(terrainId));

	//	this.serverCombatService //wim do shit
	}
	
	public void declareTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}

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
