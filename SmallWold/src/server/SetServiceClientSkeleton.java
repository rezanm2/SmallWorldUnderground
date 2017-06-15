package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.SetService;

public interface SetServiceClientSkeleton  extends Remote{
	void updateRaceList(ArrayList<String> arrayList) throws RemoteException;



}
