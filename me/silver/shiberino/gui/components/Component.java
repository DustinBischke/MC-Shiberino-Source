package me.silver.shiberino.gui.components;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.theme.Color;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public abstract class Component
{
	protected Builder builder = new Builder();
	protected Color color = new Color();
	protected FontRenderer fontRenderer = Shiberino.getInstance().getInvoker().getFontRenderer();

	public abstract void render();
}
