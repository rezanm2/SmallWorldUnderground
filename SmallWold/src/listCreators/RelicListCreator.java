package listCreators;

import java.util.ArrayList;
import java.util.List;

import races.Race;
import relics.FlyingDoormat;
import relics.FroggysRing;
import relics.KillerRabbitSword;
import relics.Relic;
import relics.ScepterOfAvarice;
import relics.ShinyOrb;
import relics.StinkyTrollSocks;

public class RelicListCreator
{
	List<Relic> relicList = new ArrayList<>();
	public RelicListCreator()
	{


		Relic flyingDoorMat = new FlyingDoormat();
		Relic froggysRing = new FroggysRing();
		Relic killerRabbitSword = new KillerRabbitSword();
		Relic scepterOfAvarice = new ScepterOfAvarice();
		Relic shinyOrb = new ShinyOrb();
		Relic stinkyTrollSocks = new StinkyTrollSocks();

		relicList.add(flyingDoorMat);
		relicList.add(froggysRing);
		relicList.add(killerRabbitSword);
		relicList.add(scepterOfAvarice);
		relicList.add(shinyOrb);
		relicList.add(stinkyTrollSocks);
	}

	public List<Relic> getRelicList()
	{
		return relicList;
	}

	public Relic getListElement(int listElement)
	{
		return getRelicList().get(listElement);
	}
}
