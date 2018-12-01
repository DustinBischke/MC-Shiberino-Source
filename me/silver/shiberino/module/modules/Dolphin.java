package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class Dolphin extends Module
{
	public Dolphin()
	{
		super("Dolphin", "Automatically Swim Up", Keyboard.CHAR_NONE, Category.MOVEMENT);
	}

	@Override
	public void onDisable()
	{
		eventManager.removeUpdateListener(this);
		invoker.setJumpKeyPressed(false);
	}

	@Override
	public void onUpdate()
	{
		if (invoker.isInWater())
		{
			invoker.setJumpKeyPressed(true);
		}
	}
}
