package specialTokens;


import playBoard.Map;
import player.Player;
/**
 *
 * Dit is de hoofdclass voor special Tokens.
 * Deze class bevat een name, traittext en een terrainNumber.
 *
 * @author Marinus van den Oever, Reza Naser
 *
 */
public abstract class SpecialToken {

	protected String name;
	protected String traitText;
	protected Player selfPlayer;
	private int terrainNumber;
	private Map map;

	public SpecialToken(){
	}

	public abstract void processSpecialToken(Player selfPlayer, Map map);
	public abstract void changeTerrain(int terrainNumber);

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}

}
