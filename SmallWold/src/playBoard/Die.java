package playBoard;

import java.util.Random;
/**
 * Deze class bevat een dobbelsteen die bij het spelbord gegooid kan worden.
 *
 * @author Bas Dorresteijn, Jeroen Zandvliet
 *
 */

public class Die
{
	private int numberOfSides = 6;
	private int result;
	Random diceThrower = new Random();
	/**
	 * Maakt een lege dobbelsteen aan.
	 */
	public Die() {
	}
	/**
	 * Maakt een dobbelsteen aan en past de numberOfSides aan.
	 *
	 * @param numberOfSides, het aantal zijdes van de dobbelsteen.
	 */
	public Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * Deze methode gooit de dobbelsteen.
	 * Wanneer het resultaat 1,2 of 3 is wordt result op 0 gezet.
	 * Wanneer 4 gegooid wordt, wordt result 1.
	 * Wanneer 5 gegooid wordt, wordt result 2.
	 * Wanneer 6 gegooid wordt, wordt result 3.
	 *
	 *
	 */
	public void throwDie()
	{
		result = diceThrower.nextInt(numberOfSides) + 1;
		if(result == 1 || result == 2 || result == 3)
		{
			result = 0;
		}
		else if(result == 4)
		{
			result = 1;
		}
		else if(result == 5)
		{
			result = 2;
		}
		else
		{
			result = 3;
		}
	}

}
