package me.silver.shiberino.hooks;

import me.silver.shiberino.event.events.EventOnUpdate;
import me.silver.shiberino.event.events.EventPostMotion;
import me.silver.shiberino.event.events.EventPreMotion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.world.World;

public class HookEntityPlayerSP extends EntityPlayerSP
{
	public HookEntityPlayerSP(Minecraft p_i47378_1_, World p_i47378_2_, NetHandlerPlayClient p_i47378_3_,
			StatisticsManager p_i47378_4_, RecipeBook p_i47378_5_)
	{
		super(p_i47378_1_, p_i47378_2_, p_i47378_3_, p_i47378_4_, p_i47378_5_);
	}

	@Override
	public void onUpdate()
	{
		final EventOnUpdate eventOnUpdate = new EventOnUpdate(this);
		eventOnUpdate.onEvent();

		super.onUpdate();
	}

	@Override
	public void onUpdateWalkingPlayer()
	{
		final EventPreMotion eventPre = new EventPreMotion(this);
		eventPre.onEvent();

		super.onUpdateWalkingPlayer();

		final EventPostMotion eventPost = new EventPostMotion(this);
		eventPost.onEvent();
	}
}
