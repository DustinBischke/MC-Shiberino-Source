package me.silver.shiberino.command;

import java.util.ArrayList;

import me.silver.shiberino.command.commands.*;

public class CommandManager
{
	private ArrayList<Command> commands = new ArrayList<>();
	private String prefix = ".";

	public void instantiateCommands()
	{
		commands.add(new FriendAdd());
		commands.add(new FriendAlias());
		commands.add(new FriendDel());
		commands.add(new FriendList());
	}

	public ArrayList<Command> getCommands()
	{
		return commands;
	}

	public String getPrefix()
	{
		return prefix;
	}

	public void onCommand(String cmd)
	{
		cmd = cmd.substring(prefix.length());

		for (Command command : commands)
		{
			if (cmd.startsWith(command.getName()))
			{
				cmd = cmd.substring(command.getName().length());

				if (command.getArgs() != null)
				{
					cmd = cmd.trim();

					if (cmd.length() == 0)
					{
						command.errorMissingParameters();
						return;
					}
				}

				command.onCommand(cmd);
			}
		}
	}
}
