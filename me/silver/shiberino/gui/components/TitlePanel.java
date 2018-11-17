package me.silver.shiberino.gui.components;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;

public class TitlePanel extends Component
{
	public void render()
	{
		String title = Shiberino.getInstance().getName();
		int width = fontRenderer.getStringWidth(title);
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		builder.drawPanel(0, 0, (width * 2) + 6, 22);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
		fontRenderer.drawString(title, 2, 2, color.textColor);
	}
}
