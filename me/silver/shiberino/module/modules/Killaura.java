package me.silver.shiberino.module.modules;

import java.util.List;

import org.lwjgl.input.Keyboard;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.friend.FriendManager;
import me.silver.shiberino.module.Category;
import me.silver.shiberino.module.Module;
import me.silver.shiberino.wrapper.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class Killaura extends Module
{
	private Wrapper wrapper = Shiberino.getInstance().getWrapper();
	private FriendManager friendManager = Shiberino.getInstance().getFriendManager();

	private EntityPlayerSP player;
	private Entity target = null;
	private float reach = 5.0f;

	public Killaura()
	{
		super("Killaura", "Automatically Attack", Keyboard.KEY_R, Category.COMBAT);
	}

	@Override
	public void onEnable()
	{
		player = Shiberino.getInstance().getWrapper().getPlayer();
		eventManager.addUpdateListener(this);
	}

	@Override
	public void onUpdate()
	{
		target = getClosestEntity();

		if (target != null)
		{
			if (isWithinReach(getClosestEntity()))
			{
				attackEntity(target);
			}
		}
	}

	private List<Entity> getEntityList()
	{
		return wrapper.getWorld().loadedEntityList;
	}

	private float getDistanceToEntity(Entity entity)
	{
		return player.getDistanceToEntity(entity);
	}

	private boolean isWithinReach(Entity entity)
	{
		if (getDistanceToEntity(entity) < reach)
		{
			return true;
		}

		return false;
	}

	private boolean isCloser(Entity next, Entity previous)
	{
		if (previous == null)
		{
			return true;
		}

		if (getDistanceToEntity(next) < getDistanceToEntity(previous))
		{
			return true;
		}

		return false;
	}

	private Entity getClosestEntity()
	{
		Entity closestEntity = null;

		for (Entity e : getEntityList())
		{
			if (e instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase) e;

				if (entity == player)
				{
					continue;
				}

				if (isCloser(entity, closestEntity))
				{
					closestEntity = entity;
				}
			}
		}

		if (closestEntity != null)
		{
			return closestEntity;
		}

		return null;
	}

	private void attackEntity(Entity entity)
	{
		wrapper.getPlayerController().attackEntity(player, entity);
	}
}
