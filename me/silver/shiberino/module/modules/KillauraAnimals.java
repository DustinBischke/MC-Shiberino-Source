package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class KillauraAnimals extends Module
{
	public KillauraAnimals()
	{
		super("Animals", "Attack Animals", Keyboard.CHAR_NONE, Category.COMBAT);
	}

	@Override
	public void onEnable()
	{
		config.killauraAnimals = true;
	}

	@Override
	public void onDisable()
	{
		config.killauraAnimals = false;
	}
}
