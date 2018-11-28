package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class AutoRespawn extends Module
{
	public AutoRespawn()
	{
		super("AutoRespawn", "Automatically Respawn", Keyboard.CHAR_NONE, Category.PLAYER);
	}

	@Override
	public void onUpdate()
	{
		invoker.respawn();
	}
}
