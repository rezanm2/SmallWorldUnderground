package controllers;

import playBoard.Map;
import player.Player;
import server.CombatServiceSkeleton;
import server.RedeployServiceSkeleton;
import terrain.Terrain;
import views.fieldView.FieldViewController;

public class RedeploymentController {
	
	private int declaredTokenAmount;
	private Terrain terrain;
	private Map map;
	private FieldViewController fieldController;
	private RedeployServiceSkeleton serverRedeployService;

	public RedeploymentController(Player selfPlayer, int playerAmount,FieldViewController fieldController, RedeployServiceSkeleton serverRedeployService  ){
		this.map = new Map(selfPlayer, playerAmount);
		this.fieldController =fieldController;
		fieldController.setRedeploymentController(this);
		this.serverRedeployService = serverRedeployService;
	}

	public void declareTokenAmount(int declaredTokenAmount) {
		this.declaredTokenAmount = declaredTokenAmount;
	}
	
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
