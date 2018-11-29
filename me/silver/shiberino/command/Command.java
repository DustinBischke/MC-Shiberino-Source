package me.silver.shiberino.command;

public abstract class Command
{
	protected String name;
	private String args;

	public Command(String name, String args)
	{
		this.name = name;
		this.args = args;
	}

	public String getName()
	{
		return name;
	}

	public String getArgs()
	{
		return args;
	}

	public abstract void onCommand(String command);

	public String[] getParts(String command)
	{
		return command.split(" ");
	}
}
