package me.silver.shiberino.friend;

public class Friend
{
	private String name;
	private String alias;

	public Friend(String name)
	{
		this.name = name;
		this.alias = name;
	}

	public String getName()
	{
		return name;
	}

	public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}
}
