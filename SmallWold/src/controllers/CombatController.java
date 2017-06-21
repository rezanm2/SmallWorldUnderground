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

<<<<<<< HEAD
	public Map getMap() {
		return this.map;
	}

=======
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
			
			if(terrain.getAmountOfTokens() + terrain.getDefense() + 2 <= declaredTokenAmount + result + miscModifier) {
				doAttack(terrain, map.getSelfPlayer());
			}
		}
	}

	private void doAttack(Terrain terrain, Player selfPlayer) {
		if(terrain.getRace() == null) { 							//if terrain is empty
			terrain.setRace(selfPlayer.getActiveSet().getRace());	//@@@@@@@@ WIM DO SHIT moet naar server gestuurd worden eigenlijk 						
			terrain.setAmountOfTokens(declaredTokenAmount);			//@@@@@@@@ WIM PLZ
		}
		else {
			losingTokens = terrain.getRace().getAmountOfTokens();
			losingTokens--;
			losingRace = terrain.getRace();
			terrain.setRace(selfPlayer.getActiveSet().getRace());	//@@@@@@@@ WIM DO SHIT moet naar server gestuurd worden eigenlijk 						
			terrain.setAmountOfTokens(declaredTokenAmount);			//@@@@@@@@ WIM PLZ
		}
		
		selfPlayer.getHand().setCurrentTokens(selfPlayer.getHand().getCurrentTokens() - declaredTokenAmount);
	}
	
	public void serverUpdateTerrain(Race winningRace, int declaredTokenAmount) {
		
	}
	
	public void serverUpdateTerrain(Race winningRace, int declaredTokenAmount, Race losingRace, int losingTokens) {
		
	}
>>>>>>> branch 'master' of https://github.com/smallWorld22/SmallWorldUnderground.git
	//TODO make functions !!



}
