package me.silver.shiberino.gui.components;

import me.silver.shiberino.gui.interfaces.Clickable;
import me.silver.shiberino.module.Module;

public class ModuleButton extends Button
{
	private Module module;
	private int textWidth;

	public ModuleButton(Module module, int x, int y, int width, int height)
	{
		super(x, y, width, height);

		this.module = module;
		textWidth = fontRenderer.getStringWidth(module.getName());
	}

	public Module getModule()
	{
		return module;
	}

	@Override
	public void render()
	{
		super.render();

		fontRenderer.drawString(module.getName(), (((x + (x + width)) / 2) / 2) - ((textWidth / 2)) + 2, (y / 2) + 2, theme.getTextColor());
	}

	@Override
	public void onClick()
	{
		module.toggle();
	}

	@Override
	public boolean isEnabled()
	{
		return module.isEnabled();
	}
}
