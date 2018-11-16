package me.silver.shiberino.wrapper;

import me.silver.shiberino.Shiberino;

public class Invoker
{
	private Wrapper wrapper = Shiberino.getInstance().getWrapper();

	public int getDisplayWidth()
	{
		return wrapper.getMinecraft().displayWidth;
	}

	public int getDisplayHeight()
	{
		return wrapper.getMinecraft().displayHeight;
	}

	public void loadRenderers()
	{
		wrapper.getMinecraft().renderGlobal.loadRenderers();
	}

	public int getPosX()
	{
		return wrapper.getPlayer().getPosition().getX();
	}

	public int getPosY()
	{
		return wrapper.getPlayer().getPosition().getY();
	}

	public int getPosZ()
	{
		return wrapper.getPlayer().getPosition().getZ();
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

	public void moveForward()
	{
		wrapper.getPlayer().movementInput.sneak = true;
	}

	public float getStepHeight()
	{
		return wrapper.getPlayer().stepHeight;
	}

	public void setStepHeight(float stepHeight)
	{
		wrapper.getPlayer().stepHeight = stepHeight;
	}

	public boolean getOnGround()
	{
		return wrapper.getPlayer().onGround;
	}

	public void setOnGround(boolean onGround)
	{
		wrapper.getPlayer().onGround = onGround;
	}

	public boolean isSneaking()
	{
		return wrapper.getPlayer().isSneaking();
	}

	public void setSprinting(boolean sprinting)
	{
		wrapper.getPlayer().setSprinting(sprinting);
	}

	public float getGammaSetting()
	{
		return wrapper.getGameSettings().gammaSetting;
	}

	public void setGammaSetting(float gamma)
	{
		wrapper.getGameSettings().gammaSetting = gamma;
	}

	public void setForwardKeyPressed(boolean pressed)
	{
		wrapper.getGameSettings().keyBindForward.setPressed(pressed);
	}

	public int getJumpKeyCode()
	{
		return wrapper.getGameSettings().keyBindJump.getKeyCode();
	}

	public void setJumpKeyPressed(boolean pressed)
	{
		wrapper.getGameSettings().keyBindJump.setPressed(pressed);
	}

	public int getSneakKeyCode()
	{
		return wrapper.getGameSettings().keyBindSneak.getKeyCode();
	}

	public void setSneakKeyPressed(boolean pressed)
	{
		wrapper.getGameSettings().keyBindSneak.setPressed(pressed);
	}
}
