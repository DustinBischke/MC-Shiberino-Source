package me.silver.shiberino.gui.components;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.gui.interfaces.Clickable;

public abstract class Button extends Component implements Clickable
{
	protected boolean enabled;

	public Button(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}

	@Override
	public void render()
	{
		int color;

		if (isEnabled())
		{
			color = theme.getEnabledColor();
		}
		else
		{
			color = theme.getDisabledColor();
		}

		GL11.glScalef(0.5f, 0.5f, 0.5f);
		builder.drawRectOutline(x, y, x + width, y + height, color);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
	}

	@Override
	public boolean isMouseOver(int mouseX, int mouseY)
	{
		if ((mouseX >= x && mouseX <= x + width) && (mouseY >= y && mouseY <= y + height))
		{
			return true;
		}

		return false;
	}

	@Override
	public abstract void onClick();

	public abstract boolean isEnabled();
}
