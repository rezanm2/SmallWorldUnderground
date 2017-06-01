package main;

import abilities.Ability;
import races.Race;

public class Set
{

	protected Ability ability;
	protected Race race;

	public Set(Ability ability, Race race)
	{
		this.ability = ability;
		this.race = race;
	}

	public void setAbility(Ability ability)
	{
		this.ability = ability;
	}

	public String getAbility()
	{
		return ability.getName();
	}

	public void setRace(Race race)
	{
		this.race = race;
	}
	public Race getRace()
	{
		return race;
	}


}
