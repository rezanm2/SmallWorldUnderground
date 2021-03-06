package models;

import java.util.ArrayList;

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
import controllers.StackController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import playBoard.Map;
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
import server.SetServiceSkeleton;
import views.settingView.SettingController;
import views.tabView.TabViewController;

/**
 * In deze class wordt een stackset aangemaakt waar de speler zijn set uit kan kiezen.
 *
 * @author Wim van der Putten, Reza Naser
 *
 */

public class StackSet {
	private ArrayList<Race> raceList = new ArrayList<Race>();
	// private ArrayList<Set> sets = new ArrayList<Set>();
	private TabViewController tabController;
	private ObservableList<Set> sets = FXCollections.observableArrayList();

	private Player selfPlayer;
	private ArrayList<Ability> abilityList = new ArrayList<Ability>();
	private ArrayList<Race> raceListGrave = new ArrayList<Race>();
	private ArrayList<Ability> abilityListGrave = new ArrayList<Ability>();
	private StackController stackController;
	private Map map;
	private SettingController settingController;
	private Race tempActiveRace2 = null;
	private Ability tempActiveAbility2 = null;
	private Race tempActiveRace = null;
	private Ability tempActiveAbility = null;
	private String playerName = "";
	private String playerName2 = "";

	/**
	 * Deze Constructor
	 *
	 * @param tabController, de controller van de tabview.
	 * @param selfPlayer, de player zelf.
	 * @param serverSetService, setservice van de server.
	 */

	public StackSet(TabViewController tabController, Player selfPlayer, SetServiceSkeleton serverSetService) {
		stackController = new StackController(this, serverSetService);
		this.selfPlayer = selfPlayer;
		this.tabController = tabController;
		settingController = this.tabController.getSettingBarController();
		setRef();
		setRefSetting();

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

		abilityList.add(new Adventurous());
		abilityList.add(new Fisher());
		abilityList.add(new Flocking());
		abilityList.add(new Frightened());
		abilityList.add(new Immortal());
		abilityList.add(new Magic());
		abilityList.add(new Martyr());
		abilityList.add(new Mining());
		abilityList.add(new Muddy());
		abilityList.add(new Mystic());
		abilityList.add(new Quarreling());
		abilityList.add(new Reborn());
		abilityList.add(new Royal());
		abilityList.add(new Shield());
		abilityList.add(new Stone());
		abilityList.add(new Thieving());
		abilityList.add(new Tomb());
		abilityList.add(new Vampire());
		abilityList.add(new Vanishing());
		abilityList.add(new Vengeful());
		abilityList.add(new Wise());

		System.out.println(this.tabController);
	}

	public ObservableList<Set> getSets() {
		return sets;
	}

	public void setSets(ObservableList<Set> sets) {
		this.sets = sets;
	}
	public void setRefSetting() {
		settingController.setStackRef(this);
	}
	public TabViewController getTabViewController() {
		return this.tabController;
	}

	public void setRef() {
		tabController.setStackRef(this);
	}
	public StackController getStackController(){
		System.out.println("returning controller..");
		return this.stackController;
	}

	public void syncStack(ArrayList<String> raceServerList, ArrayList<String> abilityServerList) {
		Race tempRace = null;
		Ability tempAbility = null;
		int i = 0;
		sets.clear();
		for (String raceString : raceServerList) { // do for each entry of the
													// string list

			for (Race race : raceList) {
				if (race.getName().toUpperCase().equals(raceString.toUpperCase())) { // compare
																						// the
																						// name
																						// of
																						// the
																						// local
																						// race
																						// to
																						// server
																						// race
					tempRace = race; // if the same remember
				}
			}
			for (Ability ability : abilityList) {
				if (ability.getName().equalsIgnoreCase(abilityServerList.get(i))) { // compare
																					// the
																					// name
																					// of
																					// the
																					// local
																					// ability
																					// to
																					// the
																					// server
																					// ability
					tempAbility = ability; // if same remember
				}
			}
			sets.add(new Set(tempRace, tempAbility)); // add to set
			i++;
		}
		sets.get(0).setCost(0);
		sets.get(1).setCost(1);
		sets.get(2).setCost(2);
		sets.get(3).setCost(3);
		sets.get(4).setCost(4);
		sets.get(5).setCost(5);

	}
	public void syncSetPlayer2(String name, String raceServerList, String abilityServerList, int amountPlayer) {
		try{
			this.playerName2 = (name);						// string list
			for (Race race : this.raceList)
			{
				if (race.getName().toUpperCase().equals(raceServerList.toUpperCase()))
				{
					this.tempActiveRace = race; // if the same remember
				}
			}
			for (Ability ability : this.abilityList) {
				if (ability.getName().equalsIgnoreCase(abilityServerList))
				{
					this.tempActiveAbility = ability; // if same remember
				}
			}
		}catch(java.lang.NullPointerException e)
		{
			System.out.println(e.getMessage());
		}

		}
	public void syncSetPlayer1(String name, String raceServerList, String abilityServerList, int amountPlayer) {
		try{
			this.playerName = name;						// string list
			for (Race race : this.raceList)
			{
				if (race.getName().toUpperCase().equals(raceServerList.toUpperCase()))
				{
					this.tempActiveRace2 = race; // if the same remember
				}
			}
			for (Ability ability : this.abilityList) {
				if (ability.getName().equalsIgnoreCase(abilityServerList))
				{
					this.tempActiveAbility2 = ability; // if same remember
				}
			}
		}catch(java.lang.NullPointerException e)
		{
			System.out.println(e.getMessage());
		}

		}

	//}
	public String getActiveAbility()
	{
		return this.tempActiveAbility.getName();
	}
	public String getActiveRace()
	{
		return this.tempActiveRace.getName();
	}
	public String getPlayerName()
	{
		return this.playerName;
	}
	public String getActiveAbility2()
	{
		return this.tempActiveAbility2.getName();
	}
	public String getActiveRace2()
	{
		return this.tempActiveRace2.getName();
	}
	public String getPlayerName2()
	{
		return this.playerName2;
	}
	public void linkStack() {
		tabController.setStack(this.sets);
	}

	public void test() {
		for (Set set : sets) {
			//System.out.println("testing sets: " + set.getAbility().getName() + " - " + set.getRace().getName());
		}

	}

	public Player getPlayer() {
		return this.selfPlayer;
	}
	public Race getRaceByName(String raceName){
		for (Race race : raceList) {
			if (race.getName().equals(raceName)){
				System.out.println("found race");
				return race;
			}
		//	System.out.println(" looking for race from server: " + raceName.toString()+ " found: " + race.getName() );
		}
		System.out.println("CLIENT SOMETHING WENT WRONG COULD NOT FIND RACE FROM SERVER");
		return null;

	}

	public ArrayList<Ability> getAbilityListGrave() {
		return abilityListGrave;
	}

	public void setAbilityListGrave(ArrayList<Ability> abilityListGrave) {
		this.abilityListGrave = abilityListGrave;
	}

	public ArrayList<Race> getRaceListGrave() {
		return raceListGrave;
	}

	public void setRaceListGrave(ArrayList<Race> raceListGrave) {
		this.raceListGrave = raceListGrave;
	}

	public void setMap(Map map) {
		this.map = map;

	}

	public void updateCost(ArrayList<Integer> gains) {
		Platform.runLater(() -> {
			tabController.updateCoinCost(gains);
		});
	}

}
