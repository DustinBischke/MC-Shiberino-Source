package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class FastLadder extends Module
{
	private float ladderSpeed = 0.5f;

	public FastLadder()
	{
		super("FastLadder", "Climb Ladders Faster", Keyboard.CHAR_NONE, Category.MOVEMENT);
	}

	@Override
	public void onUpdate()
	{
		if (invoker.isOnLadder())
		{
			if (Keyboard.isKeyDown(invoker.getForwardKeyCode()))
			{
				invoker.setMotionY(ladderSpeed);
			}
		}
	}
}
