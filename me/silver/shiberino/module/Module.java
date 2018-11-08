package me.silver.shiberino.module;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.event.Listener;
import me.silver.shiberino.event.events.EventOnUpdate;
import me.silver.shiberino.wrapper.Invoker;

public abstract class Module implements Listener
{
	protected Invoker invoker = Shiberino.getInstance().getInvoker();

	private String name;
	private String description;
	private int keyCode;
	private boolean enabled;

	public Module(String name, String description, int keyCode)
	{
		this.name = name;
		this.description = description;
		this.keyCode = keyCode;
		this.enabled = false;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public int getKeyCode()
	{
		return keyCode;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public abstract void onEnable();

	public abstract void onDisable();

	public void onUpdate(EventOnUpdate event) {}

	public void toggle()
	{
		enabled = !enabled;

		if (enabled)
		{
			onEnable();
		}
		else
		{
			onDisable();
		}
	}
}
