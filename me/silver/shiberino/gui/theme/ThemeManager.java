package me.silver.shiberino.gui.theme;

import java.util.ArrayList;

import me.silver.shiberino.gui.theme.themes.*;

public class ThemeManager
{
	private ArrayList<Theme> themes = new ArrayList<>();
	private Theme activeTheme;

	public void initializeThemes()
	{
		themes.add(new Carbon());
		themes.add(new Light());
		setActiveTheme(themes.get(0));
	}

	public ArrayList<Theme> getThemes()
	{
		return themes;
	}

	public Theme getActiveTheme()
	{
		return activeTheme;
	}

	public void setActiveTheme(Theme theme)
	{
		this.activeTheme = theme;
	}
}
