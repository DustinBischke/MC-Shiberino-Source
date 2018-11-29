package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class AutoWalk extends Module
{
	public AutoWalk()
	{
		super("AutoWalk", "Automatically Move Forward", Keyboard.CHAR_NONE, Category.MOVEMENT);
	}

	@Override
	public void onDisable()
	{
		eventManager.removeUpdateListener(this);
		invoker.setForwardKeyPressed(false);
	}

	@Override
	public void onUpdate()
	{
		invoker.setForwardKeyPressed(true);
	}
}
