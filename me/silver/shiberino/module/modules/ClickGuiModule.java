package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.xray.XrayManager;

public class ClickGuiModule extends Module
{
	public ClickGuiModule()
	{
		super("ClickGUI", "Displays the Clickable GUI", Keyboard.KEY_UP, null);
	}

	@Override
	public void onEnable()
	{
		invoker.displayScreen(Shiberino.getInstance().getClickGui());
		enabled = false;
	}

	@Override
	public void onDisable() {}
}
