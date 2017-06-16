package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.ClientSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;


public class TurnService extends UnicastRemoteObject implements TurnServiceSkeleton {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> playerList;
	private int amountPlayers;
	private ArrayList<TurnServiceClientSkeleton> turnClientList = new ArrayList<>();
	private int turn;
	private int round;
	private int endRound;
	private int playerTurn;


	public TurnService(ArrayList<String> playerList, int amountPlayers) throws RemoteException {
		this.playerList = playerList;
		this.amountPlayers = amountPlayers;
		this.turn = 0;
		this.round = 0;
		this.playerTurn = 0;
		setEndRound();
	}


	public void setEndRound(){
		switch (amountPlayers) {
		case 2:
			this.endRound = 10;
			break;
		case 3:
			this.endRound = 10;
			break;
		case 4:
			this.endRound = 9;
			break;
		case 5:
			this.endRound = 9;
			break;

		default:
			break;
		}
	}
	public void startTurn() throws RemoteException{

		int i = 0;
		for (TurnServiceClientSkeleton Turnclient : turnClientList) {
			if (i != playerTurn){
				Turnclient.updatePlayerTurn(this.playerList.get(playerTurn)); //notify's players who's turn it is.

			}else{
				Turnclient.StartTurn();								//start player's turn

			}
			i++;
		}
		this.playerTurn++;
		updateRound();


	}
	public void updateRound(){
		if (playerTurn == amountPlayers){
			if(round < endRound){							// last players turn, so increase the round
				round++;
			}else{
			//	endgame();									end the game !!@@@@@@@@ needs implementation!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			}

		}
	}


	@Override
	public void addTurnClient(TurnServiceClientSkeleton turnClient) throws RemoteException {
		turnClientList.add(turnClient);
		if (turnClientList.size() == amountPlayers){
			new Thread(() -> {
				try {
					startTurn();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}).start();

		}

	}


	@Override
	public void endTurn() throws RemoteException {
		startTurn();

	}







}
