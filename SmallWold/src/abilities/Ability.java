package abilities;

public class Ability
{

	protected String type;
	protected String traitText;
	protected int amountOfTokens;
	protected boolean active;

	public Ability()
	{
	}

	public void setType(String name)
	{
		this.type = name;
	}
	public String getType()
	{
		return type;
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
