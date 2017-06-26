package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */
public interface TurnServiceClientSkeleton  extends Remote{

	public void updatePlayerTurn(String string) throws RemoteException;

	public void StartTurn() throws RemoteException;
	String getName() throws RemoteException;
}
