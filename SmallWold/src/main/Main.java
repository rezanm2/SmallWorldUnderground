package main;


import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Flocking;
import abilities.Magic;
import controllers.CombatController;
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
		Die die = new Die();

		Ability magic = new Magic();
		Ability flocking = new Flocking();
		Race drow = new Drow();
		Race flames = new Flames();

		Hand handOne = new Hand();
		Hand handTwo = new Hand();
		Player playerOne = new Player(handOne);
		Player playerTwo = new Player(handTwo);
		Set oneActiveSet = new Set(magic, drow);
		Set twoActiveSet = new Set(flocking, flames);

		playerOne.setActiveSet(oneActiveSet);
		playerTwo.setActiveSet(twoActiveSet);

		CombatController cc = new CombatController();
		MapInitializer init = new MapInitializer();

		init.initialize();

		Map map = new Map(init.getTerrains(), die);

		map.getTerrain(3).setTokenType(playerTwo.getActiveSet().getRace().getTokenType());  //flames
		map.getTerrain(3).setAmountOfTokens(2);												//2

		System.out.println(map.getTerrain(3).getAmountOfTokens());
		System.out.println(map.getTerrain(3).getTokenType());
		
		cc.declareTokenAmount(5);
		
		cc.calculateCombat(map.getTerrain(3), playerOne, playerTwo);

		System.out.println(map.getTerrain(3).getAmountOfTokens());
		System.out.println(map.getTerrain(3).getTokenType());
	}
}
