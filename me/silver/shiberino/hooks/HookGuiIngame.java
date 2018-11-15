package me.silver.shiberino.hooks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.FontRenderer;

public class HookGuiIngame extends GuiIngame
{
	public HookGuiIngame(Minecraft mcIn)
	{
		super(mcIn);
	}

	@Override
	public void renderGameOverlay(float partialTicks)
    {
		super.renderGameOverlay(partialTicks);
    }
}
