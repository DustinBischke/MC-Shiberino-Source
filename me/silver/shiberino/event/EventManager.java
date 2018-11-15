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

	public void addModuleListener(Listener listener)
	{
		if (!moduleListeners.contains(listener))
		{
			moduleListeners.add(listener);
		}
	}

	public void removeModuleListener(Listener listener)
	{
		if (moduleListeners.contains(listener))
		{
			moduleListeners.remove(moduleListeners.indexOf(listener));
		}
	}

	public void addUpdateListener(Listener listener)
	{
		if (!updateListeners.contains(listener))
		{
			updateListeners.add(listener);
		}
	}

	public void removeUpdateListener(Listener listener)
	{
		if (updateListeners.contains(listener))
		{
			updateListeners.remove(updateListeners.indexOf(listener));
		}
	}
}
