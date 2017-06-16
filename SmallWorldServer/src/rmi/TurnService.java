package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Player;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;


public class TurnService extends UnicastRemoteObject implements TurnServiceSkeleton {

	/**
	 *@author Wim van der Putten
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Player> playerList;
	private int amountPlayers;
	private ArrayList<TurnServiceClientSkeleton> turnClientList = new ArrayList<>();
	private int turn;
	private int round;
	private int endRound;
	private int playerTurn;


	public TurnService(ArrayList<String> playerNameList, int amountPlayers, ArrayList<Player> playerList) throws RemoteException {
		this.playerList = playerList;
		this.amountPlayers = amountPlayers;
		this.turn = 0;
		this.round = 0;
		this.playerTurn = 0;
		setEndRound();
		setPlayers(playerNameList);
	}
	public void setPlayers(ArrayList<String> playerNameList){
		System.out.println(playerNameList);
		for (String name : playerNameList) {
			System.out.println(name);
			this.playerList.add(new Player(name));
		}
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
				Turnclient.updatePlayerTurn(this.playerList.get(playerTurn).getUserName()); //notify's players who's turn it is.

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
