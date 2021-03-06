package me.silver.shiberino.gui.components;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.theme.Theme;
import net.minecraft.client.gui.FontRenderer;

public abstract class Component
{
	protected Builder builder = new Builder();
	protected FontRenderer fontRenderer = Shiberino.getInstance().getInvoker().getFontRenderer();
	protected Theme theme = Shiberino.getThemeManager().getActiveTheme();
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Component(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void render();

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
