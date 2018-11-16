package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;

public class AutoWalk extends Module
{
	public AutoWalk()
	{
		super("AutoWalk", "Automatically Move Forward", Keyboard.KEY_V);
	}

	@Override
	public void onEnable()
	{
		invoker.setForwardKeyPressed(true);
	}

	@Override
	public void onDisable()
	{
		invoker.setForwardKeyPressed(false);
	}
}
