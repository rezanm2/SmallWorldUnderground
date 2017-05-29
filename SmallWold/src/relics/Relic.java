package relics;

public abstract class Relic
{
	protected String name;
	protected String traitText;

	public Relic(String name)
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
