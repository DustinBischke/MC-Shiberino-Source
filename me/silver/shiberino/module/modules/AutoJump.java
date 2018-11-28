package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class AutoJump extends Module
{
	public AutoJump()
	{
		super("AutoJump", "Automatically Jump", Keyboard.CHAR_NONE, Category.MOVEMENT);
	}

	@Override
	public void onUpdate()
	{
		invoker.setJumpKeyPressed(true);
	}
}
