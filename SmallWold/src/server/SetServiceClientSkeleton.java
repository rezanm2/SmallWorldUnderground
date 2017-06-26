package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.SetService;
/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */
public interface SetServiceClientSkeleton  extends Remote{

	void updateStackList(ArrayList<String> raceList, ArrayList<String> abilityList) throws RemoteException;

	void updateSetsPlayer1(String playerNames, String playerRaces, String playerAbilities, int amountPlayer)
			throws RemoteException;

	void updateSetsPlayer2(String name, String race, String ability, int amountPlayer) throws RemoteException;


}
