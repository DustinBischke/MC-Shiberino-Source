package me.silver.shiberino.command.commands;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.command.Command;
import me.silver.shiberino.friend.Friend;
import me.silver.shiberino.friend.FriendManager;

public class FriendAlias extends Command
{
	private FriendManager friendManager = Shiberino.getInstance().getFriendManager();

	public FriendAlias()
	{
		super("friend alias", "[name] [alias]");
	}

	@Override
	public void onCommand(String command)
	{
		String[] parts = getParts(command);

		if (parts.length == 2)
		{
			if (friendManager.isFriend(parts[0]))
			{
				Friend friendObj = friendManager.getFriend(parts[0]);
				friendObj.setAlias(parts[1]);
				invoker.addChatMessage("Changed " + parts[0] + " Alias to " + parts[1]);
			}
			else
			{
				invoker.addChatMessage(command + " is not your Friend");
			}
		}
		else
		{
			errorMissingParameters();
		}
	}
}
