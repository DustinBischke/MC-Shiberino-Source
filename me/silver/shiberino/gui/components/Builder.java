package me.silver.shiberino.gui.components;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.theme.Color;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class Builder
{
	private FontRenderer fontRenderer = Shiberino.getInstance().getInvoker().getFontRenderer();

	public void drawOutline(int x, int y, int x2, int y2)
	{
		Gui.drawRect(x - 1, y - 1, x, y2 + 1, Color.borderColor);
		Gui.drawRect(x2, y - 1, x2 + 1, y2 + 1, Color.borderColor);
		Gui.drawRect(x, y - 1, x2, y, Color.borderColor);
		Gui.drawRect(x, y2, x2, y2 + 1, Color.borderColor);
	}

	public void drawRectOutline(int x, int y, int x2, int y2, int Color)
	{
		Gui.drawRect(x, y, x2, y2, Color);
		drawOutline(x, y, x2, y2);
	}

	public void drawShadow(int x, int y, int x2, int y2)
	{
		Gui.drawRect(x2 + 1, y, x2 + 2, y2 + 2, Color.shadowColor);
		Gui.drawRect(x2 + 2, y + 1, x2 + 3, y2 + 3, Color.shadowColor2);
		Gui.drawRect(x, y2 + 1, x2 + 1, y2 + 2, Color.shadowColor);
		Gui.drawRect(x + 1, y2 + 2, x2 + 2, y2 + 3, Color.shadowColor2);
	}

	public void drawPanel(int x, int y, int x2, int y2)
	{
		drawRectOutline(x, y, x2, y2, Color.panelColor);
		drawShadow(x, y, x2, y2);
	}

	public void drawButton(String name, int x, int y, int x2, int y2, int Color1)
	{
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		drawRectOutline(x, y, x2, y2, Color1);

		GL11.glScalef(2.0f, 2.0f, 2.0f);
		int nameWidth = fontRenderer.getStringWidth(name);
		fontRenderer.drawString(name, (((x + x2) / 2) / 2) - ((nameWidth / 2)) + 2, (y / 2) + 2, Color.textColor);
	}
}
