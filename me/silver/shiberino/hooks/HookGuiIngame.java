package me.silver.shiberino.hooks;

import java.util.ArrayList;

import me.silver.shiberino.gui.components.CoordinatePanel;
import me.silver.shiberino.gui.components.ModuleList;
import me.silver.shiberino.gui.components.TitlePanel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class HookGuiIngame extends GuiIngame
{
	private TitlePanel title = new TitlePanel();
	private CoordinatePanel coordinates = new CoordinatePanel();
	private ModuleList moduleList = new ModuleList();

	public HookGuiIngame(Minecraft mcIn)
	{
		super(mcIn);
	}

	@Override
	public void renderGameOverlay(float partialTicks)
    {
		super.renderGameOverlay(partialTicks);

		title.render();
		coordinates.render();
		moduleList.render();
    }
}
