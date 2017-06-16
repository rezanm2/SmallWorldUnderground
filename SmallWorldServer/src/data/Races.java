package data;

import java.util.ArrayList;
import java.util.Collections;


public class Races {
private ArrayList<String> raceList  = new ArrayList<String>();


public Races(){
	raceList.add("Cultists");
	raceList.add("Drow");
	raceList.add("Dwarves");
	raceList.add("Flames");
	raceList.add("Gnomes");
	raceList.add("Kraken");
	raceList.add("Liches");
	raceList.add("Lizardmen");
	raceList.add("Mudmen");
	raceList.add("Mummies");
	raceList.add("Ogres");
	raceList.add("ShadowMimes");
	raceList.add("Shrooms");
	raceList.add("Spiderines");
	raceList.add("WillOWisp");
}

public void shuffleMain(){
	Collections.shuffle(raceList);
}
public ArrayList<String> getRaceList(){
	return this.raceList;
}
}
