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
		modules.add(new NoFall());
		modules.add(new Sprint());
	}

	public ArrayList<Module> getModules()
	{
		return modules;
	}
}
