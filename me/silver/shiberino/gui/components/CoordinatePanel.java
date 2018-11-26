package me.silver.shiberino.gui.components;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.theme.Color;
import me.silver.shiberino.wrapper.Invoker;

public class CoordinatePanel extends Panel
{
	private Invoker invoker = Shiberino.getInstance().getInvoker();

	public CoordinatePanel()
	{
		super(0, 32, 0, 62);
	}

	@Override
	public void render()
	{
		String posX = "X: " + Integer.toString(invoker.getPosX());
		int widthX = fontRenderer.getStringWidth(posX);
		String posY = "Y: " + Integer.toString(invoker.getPosY());
		int widthY = fontRenderer.getStringWidth(posY);
		String posZ = "Z: " + Integer.toString(invoker.getPosZ());
		int widthZ = fontRenderer.getStringWidth(posZ);
		int max = Math.max(Math.max(widthX, widthY), widthZ);

		super.setWidth((max * 2) + 6);
		super.render();

		fontRenderer.drawString(posX, 2, 18, Color.textColor);
		fontRenderer.drawString(posY, 2, 28, Color.textColor);
		fontRenderer.drawString(posZ, 2, 38, Color.textColor);
	}
}
