package me.silver.shiberino.wrapper;

import me.silver.shiberino.Shiberino;

public class Invoker
{
	private Wrapper wrapper = Shiberino.getInstance().getWrapper();

	public float getGammaSetting()
	{
		return wrapper.getGameSettings().gammaSetting;
	}

	public void setGammaSetting(float gamma)
	{
		wrapper.getGameSettings().gammaSetting = gamma;
	}

	public double getMotionX()
	{
		return wrapper.getPlayer().motionX;
	}

	public void setMotionX(double x)
	{
		wrapper.getPlayer().motionX = x;
	}

	public double getMotionY()
	{
		return wrapper.getPlayer().motionY;
	}

	public void setMotionY(double y)
	{
		wrapper.getPlayer().motionY = y;
	}

	public double getMotionZ()
	{
		return wrapper.getPlayer().motionZ;
	}

	public void setMotionZ(double z)
	{
		wrapper.getPlayer().motionZ = z;
	}

	public int getJumpKeyCode()
	{
		return wrapper.getGameSettings().keyBindJump.getKeyCode();
	}

	public int getSneakKeyCode()
	{
		return wrapper.getGameSettings().keyBindSneak.getKeyCode();
	}
}
