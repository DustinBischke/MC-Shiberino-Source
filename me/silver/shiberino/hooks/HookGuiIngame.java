package me.silver.shiberino.hooks;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.module.ModuleManager;
import me.silver.shiberino.wrapper.Invoker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;

public class HookGuiIngame extends GuiIngame
{
	private FontRenderer fontRenderer = getFontRenderer();
	private Invoker invoker = Shiberino.getInstance().getInvoker();
	private ModuleManager moduleManager = Shiberino.getInstance().getModuleManager();

	private int textColor = 0xfff7f7f7;
	private int panelColor = 0xe52d2d2d;
	private int borderColor = 0xe5080808;
	private int shadowColor = 0x55000000;

	public HookGuiIngame(Minecraft mcIn)
	{
		super(mcIn);
	}

	@Override
	public void renderGameOverlay(float partialTicks)
    {
		super.renderGameOverlay(partialTicks);

		renderTitle();
		renderCoordinates();
		renderModules();
    }

	private void drawRectOutline(int x, int y, int x2, int y2, int color, int border)
	{
		drawRect(x, y, x2, y2, color);
		drawRect(x - 1, y - 1, x, y2 + 1, border);
		drawRect(x2, y - 1, x2 + 1, y2 + 1, border);
		drawRect(x, y - 1, x2, y, border);
		drawRect(x, y2, x2, y2 + 1, border);
	}

	private void drawPanel(int x, int y, int x2, int y2)
	{
		drawRectOutline(x, y, x2, y2, panelColor, borderColor);
		drawRect(x2 + 1, y, x2 + 2, y2 + 2, shadowColor);
		drawRect(x, y2 + 1, x2 + 1, y2 + 2, shadowColor);
	}

	private void renderTitle()
	{
		String title = Shiberino.getInstance().getName();
		int width = fontRenderer.getStringWidth(title);
		drawPanel(0, 0, width + 3, 11);
		fontRenderer.drawString(title, 2, 2, textColor);
	}

	private void renderCoordinates()
	{
		String posX = "X: " + Integer.toString(invoker.getPosX());
		int widthX = fontRenderer.getStringWidth(posX);
		String posY = "Y: " + Integer.toString(invoker.getPosY());
		int widthY = fontRenderer.getStringWidth(posY);
		String posZ = "Z: " + Integer.toString(invoker.getPosZ());
		int widthZ = fontRenderer.getStringWidth(posZ);
		int max = Math.max(Math.max(widthX, widthY), widthZ);

		drawPanel(0, 16, max + 3, 47);
		fontRenderer.drawString(posX, 2, 18, textColor);
		fontRenderer.drawString(posY, 2, 28, textColor);
		fontRenderer.drawString(posZ, 2, 38, textColor);
	}

	private void renderModules()
	{
		int displayWidth = invoker.getDisplayWidth() / 2;
		int count = 0;

		for (Module module : moduleManager.getModules())
		{
			if (module.isEnabled())
			{
				String name = module.getName();
				int width = fontRenderer.getStringWidth(name);
				getFontRenderer().drawString(module.getName(), displayWidth - width - 1, 2 + (10 * count), textColor);
				count += 1;
			}
		}
	}
}
