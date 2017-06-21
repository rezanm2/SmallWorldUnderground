package controllers;

import javax.swing.text.FieldView;

import playBoard.Map;
import player.Player;
import server.CombatServiceSkeleton;
import terrain.Terrain;
import views.fieldView.FieldViewController;

public class CombatController {

	private FieldViewController fieldController;
	private Map map;
	private CombatServiceSkeleton serverCombatService;

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

	//TODO make functions !!



}
