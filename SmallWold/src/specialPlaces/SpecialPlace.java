package specialPlaces;

public abstract class SpecialPlace
{
	protected String name;
	protected String traitText;
	protected boolean active;

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
}

