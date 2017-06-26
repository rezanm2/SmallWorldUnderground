package controllers;

import main.Ammy;
import playBoard.Map;
/**
 * Deze klasse is verantwoordelijk voor het goed aanroepen van alle relics en specialPlaces.
 * @author Jeroen Zandvliet
 */
public class SpecialController
{
	Map map;

	public SpecialController(Ammy ammy)
	{
		this.map = ammy.getMap();
	}

}
