package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;
/**
 * Dit is de hoofdclass voor alle Relics.
 * Een relic bevat een naam, traitext, of deze active is en een terreinNummer.
 * 
 * @author Groep13
 *
 */
public abstract class Relic
{
	protected String name;
	protected String traitText;
	protected boolean active;
	private int terrainNumber;
	private Map map;

	public Relic()
	{
	};

	public abstract void processRelic(Ammy ammy);

	public abstract void changeTerrain(int terrainNumber);

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}

	public void setActive()
	{
		this.active = true;
	}

	public boolean getActive()
	{
		return active;
	}

	public void setTraitText(String traitText)
	{
		this.traitText = traitText;
	}

	public String getTraitText()
	{
		return traitText;
	}
}
