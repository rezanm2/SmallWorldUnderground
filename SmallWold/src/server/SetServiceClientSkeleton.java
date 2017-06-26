package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.SetService;

public interface SetServiceClientSkeleton  extends Remote{

	void updateStackList(ArrayList<String> raceList, ArrayList<String> abilityList) throws RemoteException;

	void costList(ArrayList<Integer> gains) throws RemoteException;


}
