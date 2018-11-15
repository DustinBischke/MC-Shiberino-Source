package me.silver.shiberino.event;

import java.util.ArrayList;

public class EventManager
{
	private ArrayList<Listener> moduleListeners = new ArrayList<Listener>();
	private ArrayList<Listener> updateListeners = new ArrayList<Listener>();

	public ArrayList<Listener> getModuleListeners()
	{
		return moduleListeners;
	}

	public ArrayList<Listener> getUpdateListeners()
	{
		return updateListeners;
	}

	public void registerModuleListener(Listener listener)
	{
		if (!moduleListeners.contains(listener))
		{
			moduleListeners.add(listener);
		}
	}

	public void unregisterModuleListener(Listener listener)
	{
		if (moduleListeners.contains(listener))
		{
			moduleListeners.remove(moduleListeners.indexOf(listener));
		}
	}

	public void registerUpdateListener(Listener listener)
	{
		if (!updateListeners.contains(listener))
		{
			updateListeners.add(listener);
		}
	}

	public void unregisterUpdateListener(Listener listener)
	{
		if (updateListeners.contains(listener))
		{
			updateListeners.remove(updateListeners.indexOf(listener));
		}
	}
}
