package me.silver.shiberino.command.commands;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.command.Command;
import me.silver.shiberino.friend.FriendManager;

public class FriendDel extends Command
{
	private FriendManager friendManager = Shiberino.getInstance().getFriendManager();

	public FriendDel()
	{
		super("friend del", "[name]");
	}

	@Override
	public void onCommand(String command)
	{
		if (friendManager.isFriend(command))
		{
			friendManager.removeFriend(command);
			invoker.addChatMessage("Removed Friend " + command);
		}
		else
		{
			invoker.addChatMessage(command + " is not your Friend");
		}
	}
}
