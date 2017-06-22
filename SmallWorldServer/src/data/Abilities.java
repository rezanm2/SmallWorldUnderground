package data;

import java.util.ArrayList;
import java.util.Collections;

public class Abilities {

	private ArrayList<String> abilitylist = new ArrayList<String>();
	private ArrayList<String> abilityGravelist = new ArrayList<String>();

	public Abilities() {

		abilitylist.add("Adventurous");
		abilitylist.add("Fisher");
		abilitylist.add("Flocking");
		abilitylist.add("Frightened");
		abilitylist.add("Immortal");
		abilitylist.add("Magic");
		abilitylist.add("Martyr");
		abilitylist.add("Mining");
		abilitylist.add("Muddy");
		abilitylist.add("Mystic");
		abilitylist.add("Quarreling");
		abilitylist.add("Reborn");
		abilitylist.add("Royal");
		abilitylist.add("Shield");
		abilitylist.add("Stone");
		abilitylist.add("Thieving");
		abilitylist.add("Tomb");
		abilitylist.add("Vampire");
		abilitylist.add("Vanishing");
		abilitylist.add("Vengeful");
		abilitylist.add("Wise");

	}

	public void shuffleMain(){
		Collections.shuffle(abilitylist);
	}

	public ArrayList<String> getAbilityList(){
		return this.abilitylist;
	}

	public void removeAbility(String abilityName) {
		int i = 0;
		for (String ability : abilitylist) {
			if (ability.equals(abilityName)){
				abilitylist.remove(i);
				abilityGravelist.add(ability);
				break;
			}
			i++;

		}
	}



}
