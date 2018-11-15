package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;

public class NoFall extends Module
{
	private boolean onGround = false;

	public NoFall()
	{
		super("No Fall", "Prevents Fall Damage", Keyboard.KEY_N);
	}

	@Override
	public void onEnable()
	{
		Shiberino.getInstance().getEventManager().registerUpdateListener(this);
	}

	@Override
	public void onDisable()
	{
		Shiberino.getInstance().getEventManager().unregisterUpdateListener(this);
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
