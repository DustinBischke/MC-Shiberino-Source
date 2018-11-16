package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;

public class Sprint extends Module
{
	public Sprint()
	{
		super("Sprint", "Makes You Sprint", Keyboard.KEY_G);
	}

	@Override
	public void onDisable()
	{
		eventManager.removeUpdateListener(this);
		invoker.setSprinting(false);
	}

	@Override
	public void onUpdate()
	{
		invoker.setSprinting(true);
	}
}
