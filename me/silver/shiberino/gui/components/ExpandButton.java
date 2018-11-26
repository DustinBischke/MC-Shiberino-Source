package me.silver.shiberino.gui.components;

public class ExpandButton extends Button
{
	private CategoryPanel categoryPanel;

	public ExpandButton(CategoryPanel categoryPanel, int x, int y, int size)
	{
		super(x, y, size, size);

		this.categoryPanel = categoryPanel;
	}

	@Override
	public void onClick()
	{
		categoryPanel.setOpen(!categoryPanel.isOpen());
	}

	@Override
	public boolean isEnabled()
	{
		return categoryPanel.isOpen();
	}

}
