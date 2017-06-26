package controllers;

import java.rmi.RemoteException;

import javafx.collections.ObservableList;
import models.Set;
import models.StackSet;
import player.Player;
import server.SetServiceSkeleton;
import views.tabView.TabViewController;
/**
 * Deze class controlleert de stack.
 *
 * @author Wim van der Putten, Reza Naser, Bas Dorresteijn
 *
 */
public class StackController {

	private StackSet stack;
	private SetServiceSkeleton serverSetService;

	/**
	 * Dit is de constructor van de stackcontroller.
	 * Deze krijgt een stack en een setServiceSkeleton mee.
	 *
	 * @param stack, de stack van de sets van het spel.
	 * @param serverSetService, de setservice van de server.
	 */
	public StackController(StackSet stack, SetServiceSkeleton serverSetService){
		this.stack = stack;
		this.serverSetService = serverSetService;
	}

	/**
	 * Deze methode verwerkt een keuze van een speler.
	 * De speler kan pas een actieve set kiezen wanneer hij geen actieveSet heeft.
	 * Eerst wordt de set aan de speler toegekend, daarna wordt deze set aan de gravelist toegevoegd.
	 * Als laatste wordt de view geupdate van alle spelers.
	 *
	 * @param nr, het setNummer van de gekozen set.
	 * @throws RemoteException
	 */
	public void chooseSet(int nr) throws RemoteException
	{
		Player player  = this.stack.getPlayer();
		ObservableList<Set> sets = this.stack.getSets();
		TabViewController controller  = this.stack.getTabViewController();

		if(player.getActiveSet() == null)
		{
			player.setActiveSet(new models.Set(sets.get(nr).getRace(), sets.get(nr).getAbility()));
			this.stack.getRaceListGrave().add(sets.get(nr).getRace());
			this.stack.getAbilityListGrave().add(sets.get(nr).getAbility());

			System.out.println("client: player race: " + player.getActiveSet().getRace().getName());
			System.out.println("client: player race: " + player.getActiveSet().getAbility().getName());

			controller.updateActiveSet();
			serverSetService.updateSetList(player.getActiveSet().getRace().getName(), player.getActiveSet().getAbility().getName() );

			player.setFirstAttack(true);

		}
		else {
			System.out.println("Nope al een actieve set ");
		}

	}
}
