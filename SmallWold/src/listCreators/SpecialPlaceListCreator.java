package listCreators;

import java.util.ArrayList;
import java.util.List;

import abilities.Ability;
import relics.Relic;
import specialPlaces.Empty;
import specialPlaces.AltarOfSouls;
import specialPlaces.BrassPipe;
import specialPlaces.CryptOfTombRaider;
import specialPlaces.DiamondFields;
import specialPlaces.KeepOnTheMotherland;
import specialPlaces.MineOfTheLostDwarf;
import specialPlaces.SpecialPlace;
import specialPlaces.Stonehedge;
import specialPlaces.WickedestPentacle;

public class SpecialPlaceListCreator
{
	List<SpecialPlace> specialPlaceList = new ArrayList<SpecialPlace>();

	public SpecialPlaceListCreator()
	{
		SpecialPlace empty = new Empty();
		SpecialPlace altarOfSouls = new AltarOfSouls();
		SpecialPlace brassPipe = new BrassPipe();
		SpecialPlace cryptOfTombRaider = new CryptOfTombRaider();
		SpecialPlace diamondFields = new DiamondFields();
		SpecialPlace keepOnTheMotherland = new KeepOnTheMotherland();
		SpecialPlace mineOfTheLostDwarf = new MineOfTheLostDwarf();
		SpecialPlace stoneHedge = new Stonehedge();
		SpecialPlace wickedestPentacle = new WickedestPentacle();

		specialPlaceList.add(empty);
		specialPlaceList.add(altarOfSouls);
		specialPlaceList.add(brassPipe);
		specialPlaceList.add(cryptOfTombRaider);
		specialPlaceList.add(diamondFields);
		specialPlaceList.add(keepOnTheMotherland);
		specialPlaceList.add(mineOfTheLostDwarf);
		specialPlaceList.add(stoneHedge);
		specialPlaceList.add(wickedestPentacle);
	}


	//@@make terain for marinus
	public List<SpecialPlace> getSpecialPlaceList()
	{
		return specialPlaceList;
	}

	public SpecialPlace getListElement(int listElement)
	{
		return specialPlaceList.get(listElement);
	}
}
