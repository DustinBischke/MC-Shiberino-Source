package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;

public class AutoJump extends Module
{
	public AutoJump()
	{
		super("AutoJump", "Automatically Jump", Keyboard.KEY_J);
	}

	@Override
	public void onEnable()
	{
		invoker.setJumpKeyPressed(true);
	}

	@Override
	public void onDisable()
	{
		invoker.setJumpKeyPressed(false);
	}
}
