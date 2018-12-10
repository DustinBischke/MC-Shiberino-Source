package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class AntiWeb extends Module
{
	public AntiWeb()
	{
		super("AntiWeb", "Disables Web Slowdown", Keyboard.CHAR_NONE, Category.PLAYER);
	}

	@Override
	public void onUpdate()
	{
		invoker.setInWeb(false);
	}
}
