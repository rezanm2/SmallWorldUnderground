package relics;

import main.Ammy;

public abstract class Relic
{
	protected String name;
	protected String traitText;
	protected boolean active;

	public Relic()
	{
	};
	
	public abstract void processRelic(Ammy ammy);

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
}
