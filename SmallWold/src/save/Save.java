package save;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import models.JoinedPlayers;
import player.Player;
import races.Race;
/**
 * Deze klasse is verantwoordelijk voor het opslaan van het spel.
 * @author Reza Naser
 */
public class Save implements Serializable
{
	/**
	 * Slaat het spel op
	 * @param player, geeft de speler mee.
	 */
	public void SaveNames(Player player)
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("Player.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
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
