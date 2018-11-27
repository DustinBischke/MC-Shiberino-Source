package me.silver.shiberino.gui.theme;

public abstract class Theme
{
	private String name;
	private boolean enabled;

	protected int textColor;
	protected int panelColor;
	protected int borderColor = 0xe5080808;
	protected int shadowColor = 0x99000000;
	protected int shadowColor2 = 0x44000000;
	protected int enabledColor;
	protected int disabledColor;

	public Theme(String name, int textColor, int panelColor, int enabledColor, int disabledColor)
	{
		this.name = name;
		this.textColor = textColor;
		this.panelColor = panelColor;
		this.enabledColor = enabledColor;
		this.disabledColor = disabledColor;
	}

	public String getName()
	{
		return name;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public int getTextColor()
	{
		return textColor;
	}

	public int getPanelColor()
	{
		return panelColor;
	}

	public int getBorderColor()
	{
		return borderColor;
	}

	public int getShadowColor()
	{
		return shadowColor;
	}

	public int getShadowColor2()
	{
		return shadowColor2;
	}

	public int getEnabledColor()
	{
		return enabledColor;
	}

	public int getDisabledColor()
	{
		return disabledColor;
	}
}
