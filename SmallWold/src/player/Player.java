package player;

import java.io.Serializable;

import abilities.Ability;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.Set;
import races.Race;
/**
 * Dit is de class Player, het is de speler.
 * Deze class houdt bij hoeveel coins een speler heeft, zijn/haar naam, sets, of de speler vengeful heeft en of het de speler zijn beurt is.
 *
 * @author Groep13
 *
 */
public class Player implements Serializable{
	private boolean hasVengeful;
	private int coins = 0;
	private SimpleStringProperty coinLabel  = new SimpleStringProperty("0");
	private Set activeSet;
	private Set declineSet;
	private boolean myTurn;
	private String name;


	private Hand hand;

	/**
	 * Maakt een speler aan en geeft deze een nieuwe hand.
	 * Zet de speler zijn beurt op false.
	 */
	public Player() {
		this.hand = new Hand();
		this.setMyTurn(false);
		this.setCoins(5);
	};

	/**
	 * Maakt een speler aan en geeft deze een nieuwe hand.
	 * Zet de speler zijn beurt op false.
	 * De actieve set wordt geset op de meegegeven set.
	 *
	 * @param set, de set die de speler krijgt.
	 */
	public void setCoins(int coins) {
		this.coins = coins;
		this.coinLabel.set(Integer.toString(coins));
	}

	public int getCoins() {
		return coins;
	}
	public SimpleStringProperty getCoinLabel(){
		return this.coinLabel;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Set getActiveSet() {
		return activeSet;
	}

	/**
	 * Zet de niewe actieve set en zet het aantal actieve tokens voor de speler.
	 *
	 * @param activeSet, de nieuwe actieve set voor de speler.
	 */
	public void setActiveSet(Set activeSet) {
		if(activeSet != null)
		{
			hand.setCurrentTokens(activeSet.getInitialTokens());
		}
		this.activeSet = activeSet;
	}

	public Set getDeclineSet() {
		return declineSet;
	}

	public void setDeclineSet(Set declineSet) {
		this.declineSet = declineSet;
	}

	public void setHasVengeful(boolean hasVengeful) {
		this.hasVengeful = hasVengeful;
	}

	public boolean getHasVengeful() {
		return hasVengeful;
	}

	public boolean isMyTurn() {
		return myTurn;
	}

	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
