package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class Spider extends Module
{
	private float climbSpeed = 0.25f;

	public Spider()
	{
		super("Spider", "Climb Walls", Keyboard.CHAR_NONE, Category.MOVEMENT);
	}

	@Override
	public void onUpdate()
	{
		if (invoker.isCollidedHorizontally())
		{
			if (Keyboard.isKeyDown(invoker.getForwardKeyCode()))
			{
				invoker.setMotionY(climbSpeed);
			}
		}
	}
}
