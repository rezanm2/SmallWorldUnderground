package models;

import abilities.Ability;
import races.Race;
/**
 * Deze class is een set die bestaat uit een ability en race.
 *
 * @author Wim van der Putten
 *
 */
public class Set
{

	protected Ability ability;
	protected Race race;
	protected int initialTokens;
	protected int cost;
	protected int gains;

	/**
	 * Maakt een nieuwe set aan.
	 *
	 * @param race, een race
	 * @param ability, een ability
	 */
	public Set( Race race,Ability ability)
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
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getGains() {
		return gains;
	}

	public void setGains(int gains) {
		this.gains = gains;
	}



}
