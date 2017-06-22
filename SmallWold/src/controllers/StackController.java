package controllers;

import javafx.collections.ObservableList;
import models.Set;
import models.StackSet;
import player.Player;
import server.SetServiceSkeleton;
import views.tabView.TabViewController;

public class StackController {

	private StackSet stack;
	private SetServiceSkeleton serverSetService;

	public StackController(StackSet stack, SetServiceSkeleton serverSetService){
		this.stack = stack;
		this.serverSetService = serverSetService;
	}

	public void chooseSet(int nr)
	{
		Player player  = this.stack.getPlayer();
		ObservableList<Set> sets = this.stack.getSets();
		TabViewController controller  = this.stack.getTabViewController();

		if(player.getActiveSet() == null)
		{
			player.setActiveSet(new main.Set(sets.get(nr).getAbility(), sets.get(nr).getRace()));
			this.stack.getRaceListGrave().add(sets.get(nr).getRace());
			this.stack.getAbilityListGrave().add(sets.get(nr).getAbility());
			sets.remove(nr);
			controller.setStack(sets);
			System.out.println("client: player race: " + player.getActiveSet().getRace().getName());
			System.out.println("client: player race: " + player.getActiveSet().getAbility().getName());
			controller.updateActiveSet();
		}
		else {
			System.out.println("Nope al een actieve set ");
		}

	}
}
