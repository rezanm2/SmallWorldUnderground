package abilities;

public class Ability
{

	protected String name;
	protected String traitText;

	public Ability(String name)
	{
		this.name = name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
