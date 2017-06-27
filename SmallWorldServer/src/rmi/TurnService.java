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
	private int amountPlayers;
	private ArrayList<TurnServiceClientSkeleton> turnClientList = new ArrayList<>();
	private ArrayList<Player> playerList;
	private int turn;
	private int round;
	private int endRound;
	private int playerTurn;


	public TurnService(ArrayList<Player> playerList) throws RemoteException {
		this.amountPlayers = playerList.size();
		this.playerList = playerList;
		this.turn = 0;
		this.round = 0;
		this.playerTurn = 0;
		setEndRound();
		setPlayers(playerList);
	}
	public void setPlayers( ArrayList<Player> playerList){
		System.out.println(playerList);
		for (Player player : playerList) {
			System.out.println(player.getUserName());
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
		for (TurnServiceClientSkeleton TurnClient : turnClientList) {

			if (i != playerTurn ){
				System.out.println("player turn: " +playerTurn+ i);
				System.out.println(TurnClient);
				System.out.println(turnClientList.get(playerTurn));
				TurnClient.updatePlayerTurn(turnClientList.get(playerTurn).getName()); //notify's players who's turn it is.

			}else{

				TurnClient.StartTurn(round);								//start player's turn

			}

			System.out.println(TurnClient.getName());
			i++;
		}
		this.playerTurn++;
		updateRound();


	}
	public void updateRound(){
		if (playerTurn == amountPlayers){
			if(round < endRound){							// last players turn, so increase the round
				round++;
				playerTurn = 0;
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
