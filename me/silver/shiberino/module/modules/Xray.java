package me.silver.shiberino.module.modules;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.xray.XrayManager;

public class Xray extends Module
{
	private XrayManager xrayManager = Shiberino.getInstance().getXrayManager();
	private int previousSetting;

	public Xray()
	{
		super("Xray", "See Through Blocks", Keyboard.KEY_X);
		xrayManager.initializeBlocks();
	}

	@Override
	public void onEnable()
	{
		xrayManager.setXrayEnabled(true);
		previousSetting = invoker.getAmbientOcclusion();
		invoker.setAmbientOcclusion(0);
		invoker.loadRenderers();
	}

	@Override
	public void onDisable()
	{
		xrayManager.setXrayEnabled(false);
		invoker.setAmbientOcclusion(previousSetting);
		invoker.loadRenderers();
	}
}
