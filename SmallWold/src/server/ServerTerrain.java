package server;

import java.io.Serializable;
/**
 * Deze klasse wordt naar de server toegestuurd.
 * @author Wim van der Putten
 */

public class ServerTerrain  implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected String id;
	protected int amountOfTokens;
	protected int defense;
	protected String race;

	protected boolean isAttackable;
	protected boolean isImmune;

	//protected String relic;
	//protected String specialPlace;
	//protected String specialToken;
	public ServerTerrain(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getRace(){
		return this.race;
	}
	public void setTokens(int tokens) {
		this.amountOfTokens = tokens;

	}
	public int getTokens(){
		return amountOfTokens;

	}


}
