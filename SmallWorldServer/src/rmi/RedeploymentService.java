package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Map;
import data.Player;
import server.RedeployServiceClientSkeleton;
import server.RedeployServiceSkeleton;
import server.ServerTerrain;

public class RedeploymentService  extends UnicastRemoteObject implements RedeployServiceSkeleton{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Player> playerList;
	private Map map;
	private ArrayList<RedeployServiceClientSkeleton> redeployClientList = new ArrayList<>();


	public RedeploymentService(ArrayList<Player> playerList, Map map) throws RemoteException {
		super();
		this.playerList = playerList;
		this.map = map;

	}

	@Override
	public void addRedeployClient(RedeployServiceClientSkeleton redeployClient) throws RemoteException {
		redeployClientList.add(redeployClient);

	}

	@Override
	public void updateTerrain(String terrainId, String raceName, int declaredTokenAmount) throws RemoteException {
		ServerTerrain terrain	 = map.getTerrainById(terrainId);
		updateTerrain(terrain, declaredTokenAmount);
		syncTerrainByTerrain(terrain);

	}
	private void updateTerrain(ServerTerrain terrain, int declaredTokenAmount) {
		terrain.setTokens(declaredTokenAmount);
	}

	public void syncTerrainByTerrain(ServerTerrain terrain){
		new Thread(() -> {	try {
			for (RedeployServiceClientSkeleton redeployCLient : redeployClientList) {
				redeployCLient.syncTerrain(terrain);
					}
			}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		}).start();
	}


}
