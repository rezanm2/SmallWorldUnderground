package data;

import java.util.ArrayList;
import java.util.Collections;

public class Abilitys {
	private ArrayList<String> abilityList = new ArrayList<String>();

	public Abilitys() {
		abilityList.add("adventurous");
		abilityList.add("fisher");
		abilityList.add("flocking");
		abilityList.add("frightened");
		abilityList.add("immortal");
		abilityList.add("magic");
		abilityList.add("martyr");
		abilityList.add("mining");
		abilityList.add("muddy");
		abilityList.add("mystic");
		abilityList.add("quarreling");
		abilityList.add("royal");
		abilityList.add("shield");
		abilityList.add("stone");
		abilityList.add("thieving");
		abilityList.add("tomb");
		abilityList.add("vampire");
		abilityList.add("vanishing");
		abilityList.add("vengeful");
		abilityList.add("wise");

	}

	public void shuffleMain() {
		Collections.shuffle(abilityList);
	}

	public ArrayList<String> getAbilityList() {
		return this.abilityList;
	}
}
