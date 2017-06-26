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

	public RedeploymentService(RedeploymentController redeployController) throws RemoteException {

	}

	@Override
	public void syncTerrain(ServerTerrain terrain) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
