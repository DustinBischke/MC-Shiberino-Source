package me.silver.shiberino.command.commands;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.command.Command;
import me.silver.shiberino.friend.Friend;
import me.silver.shiberino.friend.FriendManager;

public class FriendList extends Command
{
	private FriendManager friendManager = Shiberino.getInstance().getFriendManager();

	public FriendList()
	{
		super("friend list", null);
	}

	@Override
	public void onCommand(String command)
	{
		if (friendManager.getFriends().size() > 0)
		{
			String friends = "Friends: ";
			boolean first = true;

			for (Friend friend : friendManager.getFriends())
			{
				if (!first)
				{
					friends += ", ";
				}

				friends += friend.getName();
			}

			invoker.addChatMessage(friends);
		}
		else
		{
			invoker.addChatMessage("You have no friends. How sad :(");
		}
	}
}
