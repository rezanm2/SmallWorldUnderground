package models;

import abilities.Ability;
import races.Race;

public class Set {

	private Race race;
	private Ability ability;
	private int cost;
	private int gain;
	private int initialTokens;

	public Set(Race race, Ability ability) {
		this.race = race;
		this.ability = ability;
		//this.initialTokens = getInitialTokens();

	}

	public int getInitialTokens() {
		int tokens;
		tokens = this.ability.getAmountOfTokens() + this.race.getAmountOfTokens();

		return tokens;

	}

	public Race getRace() {
		return this.race;
	}

}
