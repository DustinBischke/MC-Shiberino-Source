package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class Sneak extends Module
{
	public Sneak()
	{
		super("Sneak", "Makes You Sneak", Keyboard.KEY_Z, Category.MOVEMENT);
	}

	@Override
	public void onDisable()
	{
		eventManager.removeUpdateListener(this);
		invoker.setSneakKeyPressed(false);
	}

	@Override
	public void onUpdate()
	{
		invoker.setSneakKeyPressed(true);
	}
}
