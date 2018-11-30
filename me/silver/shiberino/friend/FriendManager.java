package me.silver.shiberino.friend;

import java.util.ArrayList;

public class FriendManager
{
	private ArrayList<Friend> friends = new ArrayList<>();

	public void addFriend(String name)
	{
		friends.add(new Friend(name));
	}

	public void removeFriend(String name)
	{
		for (Friend friend : friends)
		{
			if (friend.getName().equalsIgnoreCase(name) || friend.getAlias().equalsIgnoreCase(name))
			{
				friends.remove(friend);
				break;
			}
		}
	}

	public boolean isFriend(String name)
	{
		for (Friend friend : friends)
		{
			if (friend.getName().equalsIgnoreCase(name) || friend.getAlias().equalsIgnoreCase(name))
			{
				return true;
			}
		}

		return false;
	}

	public Friend getFriend(String name)
	{
		if (isFriend(name))
		{
			for (Friend friend : friends)
			{
				if (friend.getName().equalsIgnoreCase(name) || friend.getAlias().equalsIgnoreCase(name))
				{
					return friend;
				}
			}
		}

		return null;
	}

	public ArrayList<Friend> getFriends()
	{
		return friends;
	}
}
