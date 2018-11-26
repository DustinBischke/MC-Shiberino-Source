package me.silver.shiberino.gui.components;

import me.silver.shiberino.Shiberino;

public class TitlePanel extends Panel
{
	private String title;

	public TitlePanel()
	{
		super(0, 0, 0, 22);

		title = Shiberino.getInstance().getName();
		width = (fontRenderer.getStringWidth(title) * 2) + 6;
	}

	@Override()
	public void render()
	{
		super.render();

		fontRenderer.drawString(title, 2, 2, theme.getTextColor());
	}
}
