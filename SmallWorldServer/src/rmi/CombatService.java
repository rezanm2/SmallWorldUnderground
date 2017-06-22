package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Map;
import data.Player;
import server.CombatServiceClientSkeleton;
import server.CombatServiceSkeleton;
import server.ServerTerrain;

public class CombatService  extends UnicastRemoteObject implements CombatServiceSkeleton{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Player> playerList;
	private Map map;
	private ArrayList<CombatServiceClientSkeleton> combatClientList = new ArrayList<>();


	public CombatService(ArrayList<Player> playerList, Map map) throws RemoteException {
		super();
		this.playerList = playerList;
		this.map = map;

	}

	@Override
	public void updateTerrain(String terrainId, String raceName, int declaredTokenAmount) throws RemoteException {
		ServerTerrain terrain	 = map.getTerrainById(terrainId);
		updateTerrain(terrain, raceName, declaredTokenAmount);
		syncTerrainByTerrain(terrain);



	}
	private void updateTerrain(ServerTerrain terrain, String raceName, int declaredTokenAmount) {
		terrain.setRace(raceName);
		terrain.setTokens(declaredTokenAmount);
	}

	public void syncTerrainByTerrain(ServerTerrain terrain){
		new Thread(() -> {	try {
			for (CombatServiceClientSkeleton combatClient : combatClientList) {
						combatClient.syncTerrain(terrain);
					}
			}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		}).start();
	}

	@Override
	public void addCombatClient(CombatServiceClientSkeleton combatClient) throws RemoteException {
		combatClientList.add(combatClient);

	}


}
