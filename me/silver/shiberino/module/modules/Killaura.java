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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

public class Killaura extends Module
{
	private Wrapper wrapper = Shiberino.getInstance().getWrapper();
	private FriendManager friendManager = Shiberino.getInstance().getFriendManager();

	private EntityPlayerSP player;
	private Entity target = null;
	private float reach = 5.0f;
	private boolean animals;
	private boolean mobs;
	private boolean players;

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

	private boolean isEntityAnimal(Entity entity)
	{
		return entity instanceof EntityAnimal;
	}

	private boolean isEntityMob(Entity entity)
	{
		return entity instanceof EntityMob;
	}

	private boolean isEntityPlayer(Entity entity)
	{
		return entity instanceof EntityPlayer;
	}

	private boolean isEntityFriend(Entity entity)
	{
		if (isEntityPlayer(entity))
		{
			entity = (EntityPlayer) entity;

			return friendManager.isFriend(entity.getName());
		}

		return false;
	}

	private boolean isWithinReach(Entity entity)
	{
		return getDistanceToEntity(entity) < reach;
	}

	private boolean isCloser(Entity next, Entity previous)
	{
		if (previous == null)
		{
			return true;
		}

		return getDistanceToEntity(next) < getDistanceToEntity(previous);
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
					if (config.killauraAnimals && isEntityAnimal(entity))
					{
						closestEntity = entity;
					}

					if (config.killauraMobs && isEntityMob(entity))
					{
						closestEntity = entity;
					}

					if (config.killauraPlayers && isEntityPlayer(entity))
					{
						if (!isEntityFriend(entity))
						{
							closestEntity = entity;
						}
					}
				}
			}
		}

		return closestEntity;
	}

	private void attackEntity(Entity entity)
	{
		wrapper.getPlayerController().attackEntity(player, entity);
	}
}
