package specialTokens;

import main.Ammy;
import playBoard.Map;
/**
 *
 * Dit is de hoofdclass voor special Tokens.
 * Deze class bevat een name, traittext en een terrainNumber.
 *
 * @author Marinus van den Oever
 *
 */
public abstract class SpecialToken {

	protected String name;
	protected String traitText;
	private int terrainNumber;
	private Map map;

	public SpecialToken(){
	}

	public abstract void processSpecialToken(Ammy ammy);
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
