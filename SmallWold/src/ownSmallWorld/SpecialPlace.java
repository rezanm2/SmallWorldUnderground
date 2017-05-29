package ownSmallWorld;

public abstract class SpecialPlace
{
	protected String name;
	protected String traitText;

	public SpecialPlace(String name)
	{
		this.name = name;
	};

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
