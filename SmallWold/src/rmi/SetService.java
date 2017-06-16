package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Stack;

import models.StackSet;
import player.Player;
import server.ClientSkeleton;
import server.SetServiceClientSkeleton;
import views.tabView.TabViewController;

public class SetService  extends UnicastRemoteObject implements SetServiceClientSkeleton {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TabViewController tabController;
	private StackSet stack;


	public SetService(TabViewController tabController) throws RemoteException {
		super();
		this.tabController = tabController;
	}

	@Override
	public synchronized void updateRaceList(ArrayList<String> raceList) throws RemoteException {

		System.out.println(raceList);

		//do in new thread!! heavy load

		new Thread(() -> {
			stack = new StackSet(tabController);
			System.out.println("reached1");
			stack.makeStack(raceList);
			System.out.println("reached2");

			stack.linkStack();
			System.out.println("reached3");
		}).start();




	}




}
