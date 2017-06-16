package models;

import java.util.ArrayList;

import abilities.Muddy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import player.Player;
import races.Cultists;
import races.Drow;
import races.Dwarves;
import races.Flames;
import races.Gnomes;
import races.Kraken;
import races.Liches;
import races.Lizardmen;
import races.Mudmen;
import races.Mummies;
import races.Ogres;
import races.Race;
import races.ShadowMimes;
import races.Shrooms;
import races.Spiderines;
import races.WillOWisp;
import views.tabView.TabViewController;

public class StackSet {
	private ArrayList<Race> raceList = new ArrayList<Race>();
	//private ArrayList<Set> sets = new ArrayList<Set>();
	private TabViewController tabController;
	private ObservableList<Set> sets = FXCollections.observableArrayList();
	private Player selfPlayer;
	// private List<Ability> abilityList = new ArrayList<Ability>();
	// private List<Race> raceListGrave = new ArrayList<Race>();
	// private List<Ability> abilityListGrave = new ArrayList<Ability>();

	public StackSet(TabViewController tabController, Player selfPlayer) {

		this.tabController = tabController;
		this.selfPlayer = selfPlayer;
		setRef();

		raceList.add(new Cultists());
		raceList.add(new Drow());
		raceList.add(new Dwarves());
		raceList.add(new Flames());
		raceList.add(new Gnomes());
		raceList.add(new Kraken());
		raceList.add(new Liches());
		raceList.add(new Lizardmen());
		raceList.add(new Mudmen());
		raceList.add(new Mummies());
		raceList.add(new Ogres());
		raceList.add(new Shrooms());
		raceList.add(new ShadowMimes());
		raceList.add(new Spiderines());
		raceList.add(new WillOWisp());

		System.out.println(this.tabController);
	}
	public void setRef()
	{
		tabController.setStackRef(this);
	}
	public void chooseSet(int nr)
	{
		System.out.println(selfPlayer);
		selfPlayer.setActiveSet(new main.Set(new Muddy(), sets.get(nr).getRace()));	
		//selfPlayer.getActiveSet().setRace(raceList.get(nr));
		System.out.println(selfPlayer.getActiveSet().getRace().getName());
	}
	public void makeStack(ArrayList<String> arrayList) {
		for (String string : arrayList) {
			Race tempRace = null;
			for (Race race : raceList) {
				if (race.getName().toUpperCase().equals(string.toUpperCase())) {
					tempRace = race;
				}
			}
			sets.add(new Set(tempRace, null)); //TODO need to add ability.
		}

	}

	public void linkStack(){
		tabController.setStack(this.sets);
	}
	

}
