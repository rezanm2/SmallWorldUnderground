package player;

import java.io.Serializable;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
/**
 * Dit is de class hand, deze houdt bij hoeveel tokens de speler op het moment heeft en hoeveel silverHammers hij heeft.
 *
 * @author Groep13
 *
 */
public class Hand implements Serializable
{
	private int currentTokens;
	private SimpleStringProperty currentTokensLabel  = new SimpleStringProperty();
	private int silverHammers;
	private int declineTokens;


	/**
	 * Maakt een lege hand aan.
	 */
	public Hand(){};

	public void setCurrentTokens(int currentTokens)
	{
		System.out.println(currentTokens);
		this.currentTokens = currentTokens;
		setCurrentTokensLabel(currentTokens);

	}
	public void setCurrentTokensLabel(int currentTokens){
		Platform.runLater(() -> {
			this.currentTokensLabel.set(Integer.toString(currentTokens));
	});
	}

	public int getDeclineTokens() {
		return declineTokens;
	}

	public void setDeclineTokens(int declineTokens) {
		this.declineTokens = declineTokens;
	}

	public int getCurrentTokens()
	{
		return currentTokens;
	}
	public SimpleStringProperty getCurrentTokensLabel(){
		return this.currentTokensLabel;
	}

	public void setSilverHammers(int silverHammers)
	{
		this.silverHammers = silverHammers;
	}

	public int getSilverHammers()
	{
		return silverHammers;
	}
}
