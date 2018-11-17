package me.silver.shiberino.gui.components;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;
import net.minecraft.client.gui.Gui;

public class CategoryPanel extends Component
{
	private ArrayList<ModuleButton> modules = new ArrayList<>();
	private Category category;
	private int x;
	private int y;
	private int width;
	private int headerHeight;
	private boolean dragging;
	private int offsetX;
	private int offsetY;

	public CategoryPanel(Category category, int x, int y)
	{
		this.category = category;
		this.x = x;
		this.y = y;
		width = 200;
		headerHeight = 22;
		dragging = false;
		offsetX = 0;
		offsetY = 0;

		for (Module module : Shiberino.getInstance().getModuleManager().getModules())
		{
			if (module.getCategory() == category)
			{
				modules.add(new ModuleButton(module, this));
			}
		}
	}

	public ArrayList<ModuleButton> getModules()
	{
		return modules;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}

	public void setOffsetY(int dragY)
	{
		this.offsetY = dragY;
	}

	public boolean isMouseOverHeader(int mouseX, int mouseY)
	{
		if ((mouseX >= x && mouseX <= x + width) && (mouseY >= y && mouseY <= y + headerHeight))
		{
			return true;
		}

		return false;
	}

	public void setDragging(boolean dragging)
	{
		this.dragging = dragging;
	}

	public void move(int mouseX, int mouseY)
	{
		if (dragging)
		{
			setX(mouseX + offsetX);
			setY(mouseY + offsetY);
		}
	}

	public void render()
	{
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		builder.drawPanel(x, y, x + width, (y + headerHeight) + 4 + (modules.size() * 27));
		Gui.drawRect(x, y + headerHeight, x + width, y + headerHeight + 1, color.borderColor);

		GL11.glScalef(2.0f, 2.0f, 2.0f);
		fontRenderer.drawString(category.name(), (x / 2) + 2, (y / 2) + 2, color.textColor);

		int count = 0;
		for (ModuleButton module : modules)
		{
			module.setX(x + 4);
			module.setY((y + headerHeight + 1) + 4 + (count * 27));
			module.render();
			count += 1;
		}
	}
}
