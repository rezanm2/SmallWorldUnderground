package main;


import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Flocking;
import abilities.Magic;
import controllers.CombatController;
import controllers.MapTester;
import mapInitializer.MapInitializer;
import playBoard.Die;
import playBoard.Map;
import player.Hand;
import player.Player;
import races.Drow;
import races.Flames;
import races.Race;
import relics.KillerRabbitSword;
import relics.Relic;
import specialPlaces.KeepOnTheMotherland;
import specialPlaces.SpecialPlace;
import terrain.Shroom;
import terrain.Terrain;

public class Main
{


	public static void main(String[] args)
	{
		MapInitializer init = new MapInitializer();
		Die die = new Die();
		CombatController cc = new CombatController();
		init.initialize();

		MapTester tester = new MapTester();
		Map map = new Map(init.getTerrains(), die);		//Creates the map and adds the terrains and die

		System.out.println(map.getTerrain(5).getElement(1));


	}
}
