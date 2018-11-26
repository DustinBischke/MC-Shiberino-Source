package me.silver.shiberino.gui.components;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

public class Panel extends Component
{
	private Builder builder = new Builder();

	public Panel(int x, int y, int x2, int y2)
	{
		super(x, y, x2, y2);
	}

	@Override
	public void render()
	{
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		builder.drawPanel(x, y, x + width, y + height);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
	}
}
