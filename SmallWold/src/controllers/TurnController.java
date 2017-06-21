package controllers;

import playBoard.Map;
import player.Player;
import views.sideBarView.SideBarController;

public class TurnController {

	private Map map;
	private SideBarController sideBarController;


	public TurnController(Map map, SideBarController sideBarController) {
		this.map = map;
		this.sideBarController = sideBarController;
	}

}
