package listCreators;

import java.util.ArrayList;
import java.util.List;

import races.Cultists;
import races.Drow;
import races.Dwarves;
import races.Empty;
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

public class RaceListCreator
{
	List<Race> raceList = new ArrayList<Race>();
	public RaceListCreator()
	{
		Race cultists = new Cultists();
		Race drow = new Drow();
		Race dwarves = new Dwarves();
		Race empty = new Empty();
		Race flames = new Flames();
		Race gnomes = new Gnomes();
		Race kraken = new Kraken();
		Race liches = new Liches();
		Race lizardmen = new Lizardmen();
		Race mudmen = new Mudmen();
		Race mummies = new Mummies();
		Race ogres = new Ogres();
		Race shadowMimes = new ShadowMimes();
		Race shrooms = new Shrooms();
		Race spiderines = new Spiderines();
		Race willOWisp = new WillOWisp();

		raceList.add(empty);
		raceList.add(cultists);
		raceList.add(drow);
		raceList.add(dwarves);
		raceList.add(flames);
		raceList.add(gnomes);
		raceList.add(kraken);
		raceList.add(liches);
		raceList.add(lizardmen);
		raceList.add(mudmen);
		raceList.add(mummies);
		raceList.add(ogres);
		raceList.add(shadowMimes);
		raceList.add(shrooms);
		raceList.add(spiderines);
		raceList.add(willOWisp);
	}

	public List<Race> getRaceList()
	{
		return raceList;
	}

	public Race getListElement(int listElement)
	{
		return getRaceList().get(listElement);
	}

}
