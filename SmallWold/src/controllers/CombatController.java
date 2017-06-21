package controllers;

import javax.swing.text.FieldView;

import playBoard.Map;
import player.Player;
import terrain.Terrain;
import views.fieldView.FieldViewController;

public class CombatController {

	private FieldViewController fieldController;
	private Map map;

	public CombatController(Player selfPlayer, int playerAmount,FieldViewController fieldController ){
		this.map = new Map(selfPlayer, playerAmount);
		this.fieldController =fieldController;
		fieldController.setCombatController(this);
	}

	public void testTerrain(String terrainId) {

		System.out.println(this.map.getTerrainById(terrainId));



	}

	//TODO make functions !!



}
