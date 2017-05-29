package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Freem extends Remote {
	public void printkaas() throws RemoteException;
	public void zegiets(String text) throws RemoteException;
	public String clickok(String input) throws RemoteException;

}

