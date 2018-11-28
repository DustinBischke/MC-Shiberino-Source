package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class MultiJump extends Module
{
	public MultiJump()
	{
		super("MultiJump", "Allows Jumping on Air", Keyboard.CHAR_NONE, Category.MOVEMENT);
	}

	@Override
	public void onUpdate()
	{
		invoker.setOnGround(true);
	}
}
