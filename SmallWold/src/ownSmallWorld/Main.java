package ownSmallWorld;


import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Magic;
import mapInitializer.MapInitializer;
import playBoard.Die;
import player.Hand;
import player.Player;
import races.Drow;
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
		init.initialize();

		init.getMap(4).setTokenType("Drow");
		init.getMap(6).setTokenType("Flames");
		init.getMap(8).setTokenType("Ogre");

		System.out.println(init.getMap(4).getOwnId());
		System.out.println(init.getMap(6).getOwnId());
		System.out.println(init.getMap(8).getOwnId());
	}
}
