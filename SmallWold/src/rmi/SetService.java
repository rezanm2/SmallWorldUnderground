package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Stack;

import models.StackSet;
import player.Player;
import server.ClientSkeleton;
import server.SetServiceClientSkeleton;
import server.SetServiceSkeleton;
import views.tabView.TabViewController;

public class SetService  extends UnicastRemoteObject implements SetServiceClientSkeleton {

	/**
	 * Deze klasse is verantwoordelijk voor het regelen van de sets.
	 *@author Wim van der Putten
	 */
	private static final long serialVersionUID = 1L;
	private StackSet stack;


	public SetService(StackSet stack) throws RemoteException {
		super();
		this.stack = stack;
	}


	@Override
	public synchronized void updateStackList(ArrayList<String> raceList, ArrayList<String> abilityList) throws RemoteException {

		System.out.println(raceList);

		//do in new thread!! heavy load

		new Thread(() -> {
			stack.syncStack(raceList, abilityList);
			stack.linkStack();
			stack.test();
		}).start();




	}
	@Override
	public synchronized void updateSetsPlayer2(String name, String race, String ability,int amountPlayer) throws RemoteException {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> {
			stack.syncSetPlayer2(name, race, ability, amountPlayer);
			stack.linkStack();
			stack.test();
		}).start();
		
	}


	@Override
	public synchronized void updateSetsPlayer1(String playerNames, String playerRaces, String playerAbilities, int amountPlayer)
			throws RemoteException {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> {
			stack.syncSetPlayer1(playerNames, playerRaces, playerAbilities, amountPlayer);
			stack.linkStack();
			stack.test();
		}).start();
		
	}





}
