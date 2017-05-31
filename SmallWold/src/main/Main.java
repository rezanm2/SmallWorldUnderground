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


		MapInitializer init = new MapInitializer();
		CombatController cc = new CombatController();
		init.initialize();
		Die die = new Die();
		Map map = new Map(init.getTerrains(), die);




		System.out.println(map.getTerrain(0).getIsAttackable());

		cc.isAttackable(map, 12);


		for(int i=0;i<map.getTerrains().size();i++)
		{
		System.out.println(i + 1 + " " + map.getTerrain(i).getIsAttackable());
		}





	}
}
