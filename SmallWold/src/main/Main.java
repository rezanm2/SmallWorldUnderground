package main;


import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Flocking;
import abilities.Magic;
import controllers.CombatController;
import controllers.MapTester;
import mapInitializer.FourPlayer;
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
		FourPlayer init = new FourPlayer();
		init.initialize();
		Die die = new Die();
		Map map = new Map(init.getTerrains(), die);
		Hand hand = new Hand();
		MapTester test = new MapTester(map);
		CombatController cc = new CombatController(map, test);

		Player playerOne = new Player();
		Player playerTwo = new Player();

		Ability magic = new Magic();
		Ability flocking = new Flocking();

		Race drow = new Drow();
		Race flames = new Flames();

		Set oneActiveset = new Set(magic, drow);
		Set twoActiveSet = new Set(flocking, flames);
		playerOne.setActiveSet(oneActiveset);
		playerTwo.setActiveSet(twoActiveSet);

		map.getTerrain(0).setAmountOfTokens(3);


		cc.isAttackable(15);

		cc.declareTokenAmount(7);
		cc.calculateCombat(map.getTerrain(0), playerOne, playerTwo);
	}
}
