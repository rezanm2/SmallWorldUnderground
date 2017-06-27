package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Abilities;
import data.Player;
import data.Races;
import server.SetServiceClientSkeleton;
import server.SetServiceSkeleton;
import server.TurnServiceClientSkeleton;
import server.TurnServiceSkeleton;

public class SetService extends UnicastRemoteObject implements SetServiceSkeleton {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<SetServiceClientSkeleton> setClientList = new ArrayList<>();
	private Races races;
	private Abilities abilities;
	private int amountPlayers;
	private ArrayList<Player> playerList;
	private ArrayList<String> playerNames;
	private ArrayList<String> playerRaces;
	private ArrayList<String> playerAbilities;
	private String namePlayer;


	public SetService(ArrayList<Player> playerList) throws RemoteException {
		super();
		this.playerList = playerList;
		this.amountPlayers = playerList.size();
		races = new Races();
		races.shuffleMain();
		abilities = new Abilities();
		abilities.shuffleMain();


	}

	@Override
	public void addSetClient(SetServiceClientSkeleton setClient) throws RemoteException {

		this.setClientList.add(setClient);
		if (setClientList.size() == amountPlayers){
			new Thread(() -> {
				try {

					updateClientRaceList();

				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}).start();

		}

	}
	public void updateClientRaceList() throws RemoteException{
		for (SetServiceClientSkeleton setClient : setClientList) {
			setClient.updateStackList(races.getRaceList(), abilities.getAbilityList());
			setClient.updateSetsPlayer2(playerList.get(1).getUserName(), playerList.get(1).getActiveRace(), playerList.get(1).getActiveAbility(), playerList.size());
			setClient.updateSetsPlayer1(playerList.get(0).getUserName(), playerList.get(0).getActiveRace(), playerList.get(0).getActiveAbility(), playerList.size());

//			for(int x=0;x<this.playerList.size();x++)
//			{
//				setClient.updateSetsPlayers(playerList.get(x).getUserName(), playerList.get(x).getActiveRace(), playerList.get(x).getActiveAbility(), playerList.size());
//			}
			

			
		}
	}

	@Override
	public void updateSetList(String playerName, String race, String ability) throws RemoteException{
		System.out.println(race);
		for(int x=0;x<this.playerList.size();x++)
		{
			this.namePlayer = playerName;
			if(playerList.get(x).getUserName().equals(this.namePlayer))
			{
				playerList.get(x).setActiveRace(race);
				playerList.get(x).setActiveAbility(ability);;
			}
			else
			{
				System.out.println("Niet gelukt lllllll");

			}
		}
		this.races.removeRace(race);
		System.out.println(races.getRaceList());
		this.abilities.removeAbility(ability);
		new Thread(() -> {
			try {

				updateClientRaceList();

			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}).start();

	}

	@Override
	public void updateDeclineset(String playerName, String race, String ability) throws RemoteException {
		for(int x=0;x<this.playerList.size();x++)
		{
			this.namePlayer = playerName;
			if(playerList.get(x).getUserName().equals(this.namePlayer))
			{
				playerList.get(x).setDeclineRace(race);
				playerList.get(x).setDeclineAbility(ability);
			}
			else
			{
				System.out.println("Niet gelukt lllllll");

			}
			System.out.println("I dont know!!!!!!!!!"+ playerList.get(x).getUserName());
			System.out.println("I dont know!!!!!!!!!"+ playerName);
			System.out.println("AAAABBBBIII!!!!!!!!!"+ playerList.get(x).getActiveRace());
		}
	}


	@Override
	public void giveAllInformationPlayer(String playerName, int handTokens, int declineTokens, int balance) throws RemoteException 
	{
		for(int x=0;x<this.playerList.size();x++)
		{
			this.namePlayer = playerName;
			if(playerList.get(x).getUserName().equals(this.namePlayer))
			{
				playerList.get(x).setBalance(balance);
				playerList.get(x).setHandTokens(handTokens);
				playerList.get(x).setDeclineTokens(declineTokens);
			}
			else
			{
				System.out.println("Niet gelukt lllllll");

			}
			System.out.println("I dont know!!!!!!!!!"+ playerList.get(x).getUserName());
			System.out.println("I dont know!!!!!!!!!"+ playerName);
			System.out.println("AAAABBBBIII!!!!!!!!!"+ playerList.get(x).getActiveRace());
		}
	}

	@Override
	public void updateSetsPlayers(String name, String raceList, String abilityList) throws RemoteException {
		
	}

	@Override
	public void updateSetList(String race, String ability) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	


}
