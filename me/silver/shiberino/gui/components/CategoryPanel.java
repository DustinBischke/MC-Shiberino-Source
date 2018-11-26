package me.silver.shiberino.gui.components;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.gui.interfaces.Draggable;
import me.silver.shiberino.gui.theme.Color;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;
import net.minecraft.client.gui.Gui;

public class CategoryPanel extends Panel implements Draggable
{
	private ArrayList<ModuleButton> moduleButtons = new ArrayList<>();
	private ExpandButton expandButton;
	private Category category;
	private boolean dragging;
	private boolean open;
	private boolean visible;

	private int padding = 4;
	private int buttonHeight = 22;
	private int headerHeight;
	private int dragOffsetX;
	private int dragOffsetY;

	public CategoryPanel(Category category, int x, int y)
	{
		super(x, y, 200, 0);

		this.category = category;
		dragging = false;
		open = true;
		visible = true;
		headerHeight = 22;
		dragOffsetX = 0;
		dragOffsetX = 0;

		for (Module module : Shiberino.getInstance().getModuleManager().getModules())
		{
			if (module.getCategory() == category)
			{
				moduleButtons.add(new ModuleButton(module, 0, 0, width - (padding * 2), buttonHeight));
			}
		}

		expandButton = new ExpandButton(this, 0, 0, headerHeight - (padding * 2));

		height = (headerHeight + padding) + ((buttonHeight + padding + 1) * moduleButtons.size());
	}

	public ArrayList<ModuleButton> getModuleButtons()
	{
		return moduleButtons;
	}

	public ExpandButton getExpandButton()
	{
		return expandButton;
	}

	@Override
	public void render()
	{
		super.render();

		GL11.glScalef(0.5f, 0.5f, 0.5f);
		Gui.drawRect(x, y + headerHeight, x + width, y + headerHeight + 1, Color.borderColor);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
		fontRenderer.drawString(category.name(), (x / 2) + 2, (y / 2) + 2, Color.textColor);

		expandButton.setX((x + width - padding) - expandButton.getWidth());
		expandButton.setY(y + padding);
		expandButton.render();

		if (open)
		{
			int count = 0;

			for (ModuleButton button : moduleButtons)
			{
				button.setX(x + padding);
				button.setY((y + headerHeight + 1 + padding) + ((buttonHeight + padding + 1) * count));
				button.render();
				count += 1;
			}
		}
	}

	public boolean isOpen()
	{
		return open;
	}

	public void setOpen(boolean open)
	{
		this.open = open;

		if (open)
		{
			height = (headerHeight + padding) + ((buttonHeight + padding + 1) * moduleButtons.size());
		}
		else
		{
			height = headerHeight;
		}
	}

	@Override
	public void onDrag(int mouseX, int mouseY)
	{
		if (dragging)
		{
			setX(mouseX + dragOffsetX);
			setY(mouseY + dragOffsetY);
		}
	}

	@Override
	public void setDragOffsetX(int dragOffsetX)
	{
		this.dragOffsetX = dragOffsetX;
	}

	@Override
	public void setDragOffsetY(int dragOffsetY)
	{
		this.dragOffsetY = dragOffsetY;
	}

	public boolean isMouseOverHeader(int mouseX, int mouseY)
	{
		if ((mouseX >= x && mouseX <= x + width) && (mouseY >= y && mouseY <= y + headerHeight))
		{
			return true;
		}

		return false;
	}

	@Override
	public boolean isDragging()
	{
		return dragging;
	}

	@Override
	public void setDragging(boolean dragging)
	{
		this.dragging = dragging;
	}
}
