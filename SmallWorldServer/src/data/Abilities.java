package data;

import java.util.ArrayList;
import java.util.Collections;

public class Abilities {
	
	private ArrayList<String> abilitylist;
	
	public Abilities() {
		abilitylist = new ArrayList<String>();
		
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
	
	

}
