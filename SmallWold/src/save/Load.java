package save;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het laden van een eerder opgeslagen spel.
 * @author Reza Naser
 */

public class Load {
	Player player2;

	public static void main(String[] arg){


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
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Player.dat"));
			Player player = (Player) in.readObject();
			this.player2 = player;
//			for (String line : Files.readAllLines(Paths.get("Player.dat"))) {
//				arrNames.add(line);
//			}
//			for(int x=0;x<arrNames.size();x++)
//			{
//				System.out.println((x+1) + " " + arrNames.get(x));
//			}
			System.out.println(player.isMyTurn());
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player2;

	// All done.
	}
}
