package me.silver.shiberino.wrapper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.Session;

public class Wrapper
{
	public Minecraft getMinecraft()
	{
		return Minecraft.getMinecraft();
	}

	public GameSettings getGameSettings()
	{
		return getMinecraft().gameSettings;
	}

	public EntityPlayerSP getPlayer()
	{
		return getMinecraft().player;
	}

	public WorldClient getWorld()
	{
		return getMinecraft().world;
	}

	public Session getSession()
	{
		return getMinecraft().getSession();
	}
}
