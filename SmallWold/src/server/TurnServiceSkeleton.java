package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.TurnService;
import views.sideBarView.SideBarController;

public interface TurnServiceSkeleton  extends Remote{


	void addTurnClient(TurnServiceClientSkeleton turnClient) throws RemoteException;
	void endTurn()  throws RemoteException;

}
