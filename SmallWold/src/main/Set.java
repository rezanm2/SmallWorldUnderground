package main;

import abilities.Ability;
import races.Race;

public class Set
{

	///@note DONT USE THIS ONE OUTSIDE OF AMMY!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	protected Ability ability;
	protected Race race;
	protected int initialTokens;
	protected int cost;

	public Set(Ability ability, Race race)
	{
		this.ability = ability;
		this.race = race;
		this.initialTokens = ability.getAmountOfTokens() + race.getAmountOfTokens();
	}

	public int getInitialTokens() {
		return initialTokens;
	}

	public void setInitialTokens(int initialTokens) {
		this.initialTokens = initialTokens;
	}

	public void setAbility(Ability ability)
	{
		this.ability = ability;
	}

	public Ability getAbility()
	{
		return ability;
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
