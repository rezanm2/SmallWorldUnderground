package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abilities.Ability;
import abilities.Flocking;
import abilities.Magic;
import controllers.CombatController_old;
import controllers.MapTester;
import mapInitializers.FourPlayer;
import mapInitializers.ThreePlayer;
import mapInitializers.TwoPlayer;
import playBoard.Die;
import playBoard.Map;
import player.Hand;
import player.Player;
import races.Drow;
import races.Flames;
import races.Race;
import relics.KillerRabbitSword;
import relics.Relic;
import setup.MapCreator;
import setup.PlayerCreator;
import setup.Starter;
import specialPlaces.KeepOnTheMotherland;
import specialPlaces.SpecialPlace;
import terrain.Shroom;
import terrain.Terrain;

public class Main
{
	static Starter starter = new Starter();
	public static void main(String[] args)
	{
		starter.start();
	}


}
