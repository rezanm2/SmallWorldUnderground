package ownSmallWorld;


import abilities.Ability;
import abilities.Magic;
import races.Drow;
import races.Race;
import relics.KillerRabbitSword;
import relics.Relic;
import terrain.Shroomfield;
import terrain.Terrain;

public class Main
{
	public static void main(String[] args)
	{
		Shroomfield ss1 = new Shroomfield("ss1", "drow", 5);

		ss1.setAmountOfTokens(5);
		System.out.println(ss1.getAmountOfTokens());

		ss1.setToOne();
		System.out.println(ss1.getAmountOfTokens());
	}
}
