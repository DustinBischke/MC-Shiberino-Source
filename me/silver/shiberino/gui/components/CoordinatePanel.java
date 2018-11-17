package me.silver.shiberino.gui.components;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.wrapper.Invoker;

public class CoordinatePanel extends Component
{
	private Invoker invoker = Shiberino.getInstance().getInvoker();

	public void render()
	{
		String posX = "X: " + Integer.toString(invoker.getPosX());
		int widthX = fontRenderer.getStringWidth(posX);
		String posY = "Y: " + Integer.toString(invoker.getPosY());
		int widthY = fontRenderer.getStringWidth(posY);
		String posZ = "Z: " + Integer.toString(invoker.getPosZ());
		int widthZ = fontRenderer.getStringWidth(posZ);
		int max = Math.max(Math.max(widthX, widthY), widthZ);

		GL11.glScalef(0.5f, 0.5f, 0.5f);
		builder.drawPanel(0, 32, (max * 2) + 6, 94);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
		fontRenderer.drawString(posX, 2, 18, color.textColor);
		fontRenderer.drawString(posY, 2, 28, color.textColor);
		fontRenderer.drawString(posZ, 2, 38, color.textColor);
	}
}
