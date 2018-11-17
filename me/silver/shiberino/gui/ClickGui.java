package me.silver.shiberino.gui;

import java.io.IOException;
import java.util.ArrayList;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.components.CategoryPanel;
import me.silver.shiberino.gui.components.ModuleButton;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.module.ModuleManager;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen
{
	private ModuleManager moduleManager = Shiberino.getInstance().getModuleManager();
	private static ArrayList<CategoryPanel> panels = new ArrayList<>();

	public ClickGui()
	{
		int x = 80;

		for (Category category : Category.values())
		{
			CategoryPanel panel = new CategoryPanel(category, x, 46);
			panels.add(panel);
			x += 210;
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		for (CategoryPanel panel : panels)
		{
			panel.render();
			panel.move(mouseX * 2, mouseY * 2);
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException
	{
		for (CategoryPanel panel : panels)
		{
			if(panel.isMouseOverHeader(mouseX * 2, mouseY * 2) && mouseButton == 0)
			{
				panel.setDragging(true);
				panel.setOffsetX(panel.getX() - (mouseX * 2));
				panel.setOffsetY(panel.getY() - (mouseY * 2));
				return;
			}

			for (ModuleButton button : panel.getModules())
			{
				if (button.isMouseOver(mouseX * 2, mouseY * 2))
				{
					button.getModule().toggle();
					return;
				}
			}
		}
	}

	@Override
    protected void mouseReleased(int mouseX, int mouseY, int state)
	{
		for (CategoryPanel panel : panels)
		{
			panel.setDragging(false);
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		for (Module module : moduleManager.getModules())
		{
			if (keyCode == module.getKeyCode())
			{
				module.toggle();
			}
		}

        if (keyCode == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);

            if (this.mc.currentScreen == null)
            {
                this.mc.setIngameFocus();
            }
        }
    }

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
