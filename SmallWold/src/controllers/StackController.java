package controllers;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
	private ArrayList<Integer> gains;

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
		gains = new ArrayList<Integer>();
		gains.add(0);
		gains.add(0);
		gains.add(0);
		gains.add(0);
		gains.add(0);
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

		if(player.getActiveSet() == null && player.getCoins() + gains.get(nr)>= sets.get(nr).getCost())
		{
			player.setActiveSet(new models.Set(sets.get(nr).getRace(), sets.get(nr).getAbility()));
			this.stack.getRaceListGrave().add(sets.get(nr).getRace());
			this.stack.getAbilityListGrave().add(sets.get(nr).getAbility());
			player.setCoins(player.getCoins() - sets.get(nr).getCost());
			player.setCoins(player.getCoins() + gains.get(nr));
			System.out.println("client: player race: " + player.getActiveSet().getRace().getName());
			System.out.println("client: player race: " + player.getActiveSet().getAbility().getName());

			controller.updateActiveSet();
			serverSetService.updateSetList(player.getName(),player.getActiveSet().getRace().getName(), player.getActiveSet().getAbility().getName() );
			for(int i = 0; i < nr; i++)
			{
				gains.set(i, gains.get(i) + 1);
			}
			gains.remove(nr);
			gains.add(0);
			serverSetService.updateCoinCost(gains);			
			player.setFirstAttack(true);

		}
		else {
			System.out.println("Nope al een actieve set ");
		}

	}
	
	public ArrayList<Integer> getGains() {
		return gains;
	}

	public void setGains(ArrayList<Integer> gains) {
		this.gains = gains;
	}

	public void setDecline() throws RemoteException
	{
		Player player  = this.stack.getPlayer();
		player.setDeclineSet(player.getActiveSet());
		System.out.println("Set is now declined");
		serverSetService.updateDeclineset(player.getName(), player.getDeclineSet().getRace().getName(), player.getDeclineSet().getAbility().getName());
	}
	public void setServiceSkeleton(SetServiceSkeleton serverSetService)
	{
		this.serverSetService = serverSetService;
	}

	public void getAllInformationPlayer() throws RemoteException {
		Player player  = this.stack.getPlayer();
		serverSetService.giveAllInformationPlayer(player.getName(), player.getHand().getCurrentTokens(), player.getHand().getDeclineTokens(), player.getCoins());
	}
}
