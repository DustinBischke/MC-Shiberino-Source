package me.silver.shiberino.command.commands;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.command.Command;
import me.silver.shiberino.friend.FriendManager;

public class FriendAdd extends Command
{
	private FriendManager friendManager = Shiberino.getInstance().getFriendManager();

	public FriendAdd()
	{
		super("friend add", "[name]");
	}

	@Override
	public void onCommand(String command)
	{
		if (!friendManager.isFriend(command))
		{
			friendManager.addFriend(command);
			invoker.addChatMessage("Added Friend " + command);
		}
		else
		{
			invoker.addChatMessage(command + " is already your Friend");
		}
	}
}
