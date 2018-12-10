package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class KillauraMobs extends Module
{
	public KillauraMobs()
	{
		super("Mobs", "Attack Mobs", Keyboard.CHAR_NONE, Category.COMBAT);
	}

	@Override
	public void onEnable()
	{
		config.killauraMobs = true;
	}

	@Override
	public void onDisable()
	{
		config.killauraMobs = false;
	}
}
