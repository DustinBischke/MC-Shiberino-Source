package me.silver.shiberino;

import org.lwjgl.opengl.Display;

import me.silver.shiberino.event.EventManager;
import me.silver.shiberino.module.ModuleManager;
import me.silver.shiberino.wrapper.Invoker;
import me.silver.shiberino.wrapper.Wrapper;

public class Shiberino
{
	private static Shiberino instance;
	private static Wrapper wrapper;
	private static ModuleManager moduleManager;
	private static Invoker invoker;
	private static EventManager eventManager;

	private final String name = "Shiberino";
	private final String version = "0.1 Alpha";
	private final String author = "Silver#4636";

	public static Shiberino getInstance()
	{
		if (instance == null)
		{
			instance = new Shiberino();
		}

		return instance;
	}

	public static Wrapper getWrapper()
	{
		if (wrapper == null)
		{
			wrapper = new Wrapper();
		}

		return wrapper;
	}

	public static ModuleManager getModuleManager()
	{
		if (moduleManager == null)
		{
			moduleManager = new ModuleManager();
		}

		return moduleManager;
	}

	public Invoker getInvoker()
	{
		if (invoker == null)
		{
			invoker = new Invoker();
		}

		return invoker;
	}

	public static EventManager getEventManager()
	{
		if (eventManager == null)
		{
			eventManager = new EventManager();
		}

		return eventManager;
	}

	public String getName()
	{
		return name;
	}

	public String getVersion()
	{
		return version;
	}

	public String getAuthor()
	{
		return author;
	}

	public void start()
	{
		Display.setTitle(name + " Version " + version);
		getModuleManager().instantiateModules();
	}
}
