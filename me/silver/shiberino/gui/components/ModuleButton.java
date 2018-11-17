package me.silver.shiberino.gui.components;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class ModuleButton extends Component
{
	private FontRenderer fontRenderer = Shiberino.getInstance().getInvoker().getFontRenderer();
	private Module module;
	private CategoryPanel categoryPanel;

	private int x = 0;
	private int y = 0;
	private int width = 192;
	private int height = 22;

	public ModuleButton(Module module, CategoryPanel categoryPanel)
	{
		this.module = module;
		this.categoryPanel = categoryPanel;
	}

	public Module getModule()
	{
		return module;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public boolean isMouseOver(int mouseX, int mouseY)
	{
		if ((mouseX >= x && mouseX <= x + width) && (mouseY >= y && mouseY <= y + height))
		{
			return true;
		}

		return false;
	}

	public void render()
	{
		int buttonColor;

		if (module.isEnabled())
		{
			buttonColor = color.enabledColor;
		}
		else
		{
			buttonColor = color.disabledColor;
		}

		builder.drawButton(module.getName(), x, y, x + width, y + height, buttonColor);
	}
}
