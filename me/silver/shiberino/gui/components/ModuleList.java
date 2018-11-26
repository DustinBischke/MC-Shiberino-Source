package me.silver.shiberino.gui.components;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.theme.Theme;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.module.ModuleManager;
import me.silver.shiberino.wrapper.Invoker;
import net.minecraft.client.gui.FontRenderer;

public class ModuleList
{
	private FontRenderer fontRenderer = Shiberino.getInstance().getInvoker().getFontRenderer();
	private Invoker invoker = Shiberino.getInstance().getInvoker();
	private ModuleManager moduleManager = Shiberino.getInstance().getModuleManager();
	private Theme theme = Shiberino.getInstance().getThemeManager().getActiveTheme();

	public void render()
	{
		int displayWidth = invoker.getDisplayWidth() / 2;
		int count = 0;

		for (Module module : moduleManager.getModules())
		{
			if (module.isEnabled())
			{
				String name = module.getName();
				int width = fontRenderer.getStringWidth(name);
				fontRenderer.drawString(module.getName(), displayWidth - width - 1, 2 + (10 * count), theme.getTextColor());
				count += 1;
			}
		}
	}
}
