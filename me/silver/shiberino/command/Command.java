package me.silver.shiberino.command;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.wrapper.Invoker;

public abstract class Command
{
	protected Invoker invoker = Shiberino.getInstance().getInvoker();
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

	public void errorMissingParameters()
	{
		invoker.addChatMessage("Missing Parameters");
	}
}
