package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class NoFall extends Module
{
	private boolean onGround;

	public NoFall()
	{
		super("NoFall", "Prevents Fall Damage", Keyboard.KEY_N, Category.PLAYER);
	}

	@Override
	public void onPreMotion()
	{
		onGround = invoker.getOnGround();
		invoker.setOnGround(true);
	}

	@Override
	public void onPostMotion()
	{
		invoker.setOnGround(onGround);
	}
}
