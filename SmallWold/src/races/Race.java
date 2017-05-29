package races;

public abstract class Race
{


	protected int amountOfTokens;
	protected int maxTokens;
	protected String name;
	protected String traitText;

	public Race(String name, int amountOfTokens, int maxTokens)
	{
		this.name = name;
		this.amountOfTokens = amountOfTokens;
		this.maxTokens = maxTokens;
	}

	public void setAmountOfTokens(int amountOfTokens)
	{
		this.amountOfTokens = amountOfTokens;
	}
	public int getAmountOfTokens()
	{
		return amountOfTokens;
	}

	public void setMaxTokens(int maxTokens)
	{
		this.maxTokens = maxTokens;
	}

	public int getMaxTokens()
	{
		return maxTokens;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setTraitText(String traitText)
	{
		this.traitText = traitText;
	}
	public String getTraitText()
	{
		return traitText;
	}
}

