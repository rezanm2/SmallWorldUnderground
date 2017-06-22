package specialPlaces;

import main.Ammy;
import player.Player;
/**
 * 
 * Dit is de hoofdclass voor specialPlaces. 
 * Deze class bevat een name, traittext en of deze active is.
 * 
 * @author bas_d
 *
 */
public abstract class SpecialPlace
{
	protected String name;
	protected String traitText;
	protected boolean active;
	protected Player activePlayer;

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

	public abstract void processSpecialPlace(Ammy ammy);
}

