package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;
import terrain.Terrain;

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
}
