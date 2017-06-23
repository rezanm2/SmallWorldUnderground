package server;

import java.rmi.Remote;
/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */
import java.rmi.RemoteException;
public interface TurnServiceSkeleton  extends Remote{


	void addTurnClient(TurnServiceClientSkeleton turnClient) throws RemoteException;
	void endTurn()  throws RemoteException;

}
