package me.silver.shiberino.module;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.config.Config;
import me.silver.shiberino.event.EventManager;
import me.silver.shiberino.event.Listener;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.wrapper.Invoker;

public class Module implements Listener
{
	protected Config config = Shiberino.getInstance().getConfig();
	protected EventManager eventManager = Shiberino.getInstance().getEventManager();
	protected Invoker invoker = Shiberino.getInstance().getInvoker();
	protected boolean enabled;

	private String name;
	private String description;
	private int keyCode;
	private Category category;

	public Module(String name, String description, int keyCode, Category category)
	{
		this.name = name;
		this.description = description;
		this.keyCode = keyCode;
		this.category = category;
		eventManager.addModuleListener(this);
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public Category getCategory()
	{
		return category;
	}

	public int getKeyCode()
	{
		return keyCode;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void onEnable()
	{
		eventManager.addUpdateListener(this);
	}

	public void onDisable()
	{
		eventManager.removeUpdateListener(this);
	}

	public void onUpdate() {}

	public void onPreMotion() {}

	public void onPostMotion() {}

	public void onKeyPress(int keyCode)
	{
		if (keyCode == this.keyCode)
		{
			toggle();
		}
	}

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
