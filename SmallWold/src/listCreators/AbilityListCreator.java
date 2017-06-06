package listCreators;

import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import abilities.Adventurous;
import abilities.Fisher;
import abilities.Flocking;
import abilities.Frightened;
import abilities.Immortal;
import abilities.Magic;
import abilities.Martyr;
import abilities.Mining;
import abilities.Muddy;
import abilities.Mystic;
import abilities.Quarreling;
import abilities.Reborn;
import abilities.Royal;
import abilities.Shield;
import abilities.Stone;
import abilities.Thieving;
import abilities.Tomb;
import abilities.Vampire;
import abilities.Vanishing;
import abilities.Vengeful;
import abilities.Wise;
import abilities.Empty;

public class AbilityListCreator
{
	List<Ability> abilityList = new ArrayList<Ability>();
	public AbilityListCreator()
	{
		Ability adventurous = new Adventurous();
		Ability	fisher = new Fisher();
		Ability flocking = new Flocking();
		Ability frightened = new Frightened();
		Ability immortal = new Immortal();
		Ability magic = new Magic();
		Ability martyr = new Martyr();
		Ability mining = new Mining();
		Ability muddy = new Muddy();
		Ability mystic = new Mystic();
		Ability quarreling = new Quarreling();
		Ability reborn = new Reborn();
		Ability royal = new Royal();
		Ability shield = new Shield();
		Ability stone = new Stone();
		Ability thieving = new Thieving();
		Ability tomb = new Tomb();
		Ability vampire = new Vampire();
		Ability vanishing = new Vanishing();
		Ability vengeful = new Vengeful();
		Ability wise = new Wise();
		Ability empty = new Empty();

		abilityList.add(empty);
		abilityList.add(adventurous);
		abilityList.add(fisher);
		abilityList.add(flocking);
		abilityList.add(frightened);
		abilityList.add(immortal);
		abilityList.add(magic);
		abilityList.add(martyr);
		abilityList.add(mining);
		abilityList.add(muddy);
		abilityList.add(mystic);
		abilityList.add(quarreling);
		abilityList.add(reborn);
		abilityList.add(royal);
		abilityList.add(shield);
		abilityList.add(stone);
		abilityList.add(thieving);
		abilityList.add(tomb);
		abilityList.add(vampire);
		abilityList.add(vanishing);
		abilityList.add(vengeful);
		abilityList.add(wise);
	}

	public List<Ability> getAbilityList()
	{
		return abilityList;
	}

	public Ability getListElement(int listElement)
	{
		return getAbilityList().get(listElement);
	}
}
