package ownSmallWorld;


import abilities.Ability;
import abilities.Magic;
import player.Hand;
import player.Player;
import races.Drow;
import races.Race;
import relics.KillerRabbitSword;
import relics.Relic;
import specialPlaces.KeepOnTheMotherland;
import specialPlaces.SpecialPlace;
import terrain.Shroomfield;
import terrain.Terrain;

public class Main
{
	public static void main(String[] args)
	{
		Hand handOne = new Hand();
		Player playerOne = new Player(handOne);
		handOne.setSilverHammers(5);
		System.out.println(handOne.getSilverHammers());
	}
}
