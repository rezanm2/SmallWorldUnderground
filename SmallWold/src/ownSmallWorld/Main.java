package ownSmallWorld;


import abilities.Ability;
import abilities.Magic;
import races.Drow;
import races.Race;
import relics.KillerRabbitSword;
import relics.Relic;

public class Main
{
	public static void main(String[] args)
	{
		Race drow = new Drow("Drow", 77, 7);

		System.out.println(drow.getTraitText() + "\n");

		Relic killerRabbitSword = new KillerRabbitSword("Sword of the killer rabbit");
		Ability magic = new Magic("Magic");

		Set setOne = new Set(magic, drow);



		System.out.println(setOne.getRace());


	}
}
