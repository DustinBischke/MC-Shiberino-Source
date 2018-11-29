package me.silver.shiberino.command;

import java.util.ArrayList;

import me.silver.shiberino.command.commands.*;

public class CommandManager
{
	private ArrayList<Command> commands = new ArrayList<>();
	private char prefix = '.';

	public void instantiateCommands()
	{

	}

	public ArrayList<Command> getCommands()
	{
		return commands;
	}

	public char getPrefix()
	{
		return prefix;
	}

	public void onCommand(String cmd)
	{
		if (cmd.startsWith(String.valueOf(prefix)))
		{
			cmd = cmd.substring(1);

			for (Command command : commands)
			{
				if (cmd.startsWith(command.getName()))
				{
					cmd = cmd.substring(command.getName().length());

					if (command.getArgs() != null)
					{
						cmd = cmd.substring(1);
					}

					command.onCommand(cmd);
				}
			}
		}
	}
}
