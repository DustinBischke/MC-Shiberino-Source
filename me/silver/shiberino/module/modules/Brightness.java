package me.silver.shiberino.module.modules;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.xray.XrayManager;

public class Brightness extends Module
{
	private float highGamma = 12.0F;
	private float lowGamma = 1.0F;
	private float fade = 1.0F;

	public Brightness()
	{
		super("Brightness", "Increases Brightness", Keyboard.KEY_C, Category.WORLD);
		eventManager.addUpdateListener(this);
	}

	@Override
	public void onEnable() {}

	@Override
	public void onDisable() {}

	@Override
	public void onUpdate()
	{
		float gammaSetting = invoker.getGammaSetting();

		if (enabled || Shiberino.getInstance().getXrayManager().isXrayEnabled())
		{
			if (gammaSetting < highGamma)
			{
				invoker.setGammaSetting(gammaSetting + fade);
			}
		}
		else
		{
			if (gammaSetting > lowGamma)
			{
				invoker.setGammaSetting(gammaSetting - fade);
			}
		}
	}
}
