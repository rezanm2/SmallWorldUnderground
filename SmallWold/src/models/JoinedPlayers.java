package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Deze klasse houdt bij welke spelers in de lobby zijn.
 * @author Wim van der Putten
 *
 */
public class JoinedPlayers {
	 private final StringProperty playerName;

	 public JoinedPlayers(String name){
		 this.playerName = new SimpleStringProperty(name);
	 }
	 public String getPlayerName(){
		 return this.playerName.get();
	 }

public StringProperty getPlayerNameProperty(){
	 return this.playerName;
}
	 public Runnable setPlayerName(String name){
		 this.playerName.set(name);
		return null;
	 }
}
