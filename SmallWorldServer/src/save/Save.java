package save;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Map;
import data.Player;
import javafx.collections.ObservableList;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van het spel.
 * @author Reza Naser
 */
public class Save  implements Serializable
{

	/**
	 * Slaat het spel op
	 * @param player, geeft de speler mee.
	 */
	private ArrayList<Player> player;
	
	public void SaveNames(ArrayList<Player> player, Map map)
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			for(int x=0;x<player.size();x++)
			{
				fos = new FileOutputStream(player.get(x).getUserName()+".dat");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(player.get(x));
				
				
			}
			fos = new FileOutputStream("Map.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			this.player = player;
			System.out.println("Game saved.");
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try(FileWriter fw = new FileWriter("playersNames.txt", true);
//			    BufferedWriter bw = new BufferedWriter(fw);
//			    PrintWriter out = new PrintWriter(bw))
//			{
//				out.println(player.getUserName());
//			} catch (IOException e)
//			{
//				System.out.println(e.getMessage());
//			}

//	public void SaveRaces(Races race)
//	{
//		try(FileWriter fw = new FileWriter("playersRaces.txt", true);
//			    BufferedWriter bw = new BufferedWriter(fw);
//			    PrintWriter out = new PrintWriter(bw))
//			{
//				out.println(race.);
//			} catch (IOException e)
//			{
//				System.out.println(e.getMessage());
//			}
//	}
	}

}
