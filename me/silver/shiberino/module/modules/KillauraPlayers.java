package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;

public class KillauraPlayers extends Module
{
	public KillauraPlayers()
	{
		super("Players", "Attack Players", Keyboard.CHAR_NONE, Category.COMBAT);
	}

	@Override
	public void onEnable()
	{
		config.killauraPlayers = true;
	}

	@Override
	public void onDisable()
	{
		config.killauraPlayers = false;
	}
}
