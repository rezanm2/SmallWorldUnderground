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
	public void costList(ArrayList<Integer> gains) throws RemoteException {
		System.out.println(gains);
		stack.updateCost(gains);		
	}





}
