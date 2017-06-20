package controllers;

import javax.swing.text.FieldView;

import playBoard.Map;
import player.Player;
import views.fieldView.FieldViewController;

public class CombatController {

	private FieldViewController fieldController;
	private Map map;

	public CombatController(Player selfPlayer, int playerAmount,FieldViewController fieldController ){
		this.map = new Map(selfPlayer, playerAmount);
		this.fieldController =fieldController;
	}

	//TODO make functions !!


}
