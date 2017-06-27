package save;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import data.Map;
import data.Player;
/**
 * Deze klasse is verantwoordelijk voor het laden van een eerder opgeslagen spel.
 * @author Reza Naser
 */

public class Load {
	Player player2;

	public static void main(String[] arg){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Reza.dat"));
			Player player = (Player) in.readObject();
			System.out.println(player.getActiveRace()+ " " + player.getActiveAbility());
			System.out.println(player.getDeclineRace() + " " + player.getDeclineAbility());
			System.out.println(player.getHandTokens() + " " + player.getBalance()+ " " + player.getDeclineTokens());
			ObjectInputStream map2 = new ObjectInputStream(new FileInputStream("Map.dat"));
			Map map = (Map) map2.readObject();
			for(int x=0;x<map.getTerrains().size();x++)
			{
				System.out.println(map.getTerrains().get(x).getRace());
			}
			
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		}
//		catch(Exception exc){
//		exc.printStackTrace(); // If there was an error, print the info.
//		}
	}
	/**
	 * Laad het spel.
	 * @return player2, de spelers.
	 */
	public Player loaden()
	{

		return player2;

	// All done.
	}
}
