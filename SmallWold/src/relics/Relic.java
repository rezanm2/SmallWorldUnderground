package relics;

import main.Ammy;
import playBoard.Map;
import player.Player;

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
	
	public void changeTerrain(int terrainNumber) {
		map.getTerrain(this.terrainNumber).setRelic(new Empty());
		map.getTerrain(terrainNumber).setRelic(this);
		this.terrainNumber = terrainNumber;
	}

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
