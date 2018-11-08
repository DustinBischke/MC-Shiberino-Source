package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;

public class Brightness extends Module
{
	private float gamma = 10.0F;
	private float previousGamma;

	public Brightness()
	{
		super("Brightness", "Raises Game Brightness", Keyboard.KEY_C);
	}

	@Override
	public void onEnable()
	{
		previousGamma = invoker.getGammaSetting();
		invoker.setGammaSetting(gamma);
	}

	@Override
	public void onDisable()
	{
		invoker.setGammaSetting(previousGamma);
	}
}
