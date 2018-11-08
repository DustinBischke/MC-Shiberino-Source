package me.silver.shiberino.module;

import java.util.ArrayList;

import me.silver.shiberino.module.modules.*;

public class ModuleManager
{
	private static ArrayList<Module> modules = new ArrayList<Module>();

	public void instantiateModules()
	{
		modules.add(new Brightness());
		modules.add(new Flight());
	}

	public ArrayList<Module> getModules()
	{
		return modules;
	}

	public void onKeyPressed(int keyCode)
	{
		for (Module module : modules)
		{
			if (module.getKeyCode() == keyCode)
			{
				module.toggle();
				break;
			}
		}
	}
}
