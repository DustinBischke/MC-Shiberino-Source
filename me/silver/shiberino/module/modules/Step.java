package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class Step extends Module
{
	private float stepHeight = 1.0F;
	private float previousHeight;

	public Step()
	{
		super("Step", "Increases Step Height", Keyboard.KEY_B, Category.MOVEMENT);
	}

	@Override
	public void onEnable()
	{
		previousHeight = invoker.getStepHeight();
		invoker.setStepHeight(stepHeight);
	}

	@Override
	public void onDisable()
	{
		invoker.setStepHeight(previousHeight);
	}
}
