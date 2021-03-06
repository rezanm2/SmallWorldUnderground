package specialPlaces;

import playBoard.Map;
import player.Player;
/**
 *
 * Dit is de hoofdclass voor specialPlaces.
 * Deze class bevat een name, traittext en of deze active is.
 *
 * @author  Bas Dorresteijn
 *
 */
public abstract class SpecialPlace
{
	protected String name;
	protected String traitText;
	protected boolean active;
	protected Player selfPlayer;

	public SpecialPlace()
	{
	};

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}

	public void setActive(boolean active)
	{
		this.active = active;
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

	public abstract void processSpecialPlace(Player selfPlayer, Map map);
}

