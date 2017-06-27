package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controllers.RedeploymentController;

import server.RedeployServiceClientSkeleton;
import server.ServerTerrain;

public class RedeploymentService extends UnicastRemoteObject implements RedeployServiceClientSkeleton {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private RedeploymentController redeployController;

	public RedeploymentService(RedeploymentController redeployController) throws RemoteException {
		this.redeployController = redeployController;
	}

	@Override
	public void syncTerrain(ServerTerrain terrain) throws RemoteException {
		System.out.println("syncing terrain");

		ServerTerrain serverTerrain = (ServerTerrain)terrain;

		this.redeployController.syncTerrain(serverTerrain);

	}

}
