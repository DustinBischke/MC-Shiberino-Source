package me.silver.shiberino.module;

import java.util.ArrayList;

import me.silver.shiberino.module.modules.*;

public class ModuleManager
{
	private ArrayList<Module> modules = new ArrayList<>();

	public void instantiateModules()
	{
		modules.add(new AntiWeb());
		modules.add(new AutoJump());
		modules.add(new AutoWalk());
		modules.add(new AutoRespawn());
		modules.add(new Brightness());
		modules.add(new ClickGuiModule());
		modules.add(new Dolphin());
		modules.add(new FastLadder());
		modules.add(new Flight());
		modules.add(new Killaura());
		modules.add(new KillauraAnimals());
		modules.add(new KillauraMobs());
		modules.add(new KillauraPlayers());
		modules.add(new MultiJump());
		modules.add(new NoFall());
		modules.add(new Sneak());
		modules.add(new Spider());
		modules.add(new Sprint());
		modules.add(new Step());
		modules.add(new Xray());
	}

	public ArrayList<Module> getModules()
	{
		return modules;
	}
}
