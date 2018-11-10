package me.silver.shiberino.event;

import java.util.ArrayList;

public class EventManager
{
	private ArrayList<Listener> listeners = new ArrayList<Listener>();

	public ArrayList<Listener> getListeners()
	{
		return listeners;
	}

	public void register(Listener listener)
	{
		if (!listeners.contains(listener))
		{
			listeners.add(listener);
		}
	}

	public void unregister(Listener listener)
	{
		if (listeners.contains(listener))
		{
			listeners.remove(listeners.indexOf(listener));
		}
	}
}
