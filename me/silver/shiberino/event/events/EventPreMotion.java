package me.silver.shiberino.event.events;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.event.Event;
import me.silver.shiberino.event.Listener;
import net.minecraft.entity.player.EntityPlayer;

public class EventPreMotion implements Event
{
	private EntityPlayer entityPlayer;

	public EventPreMotion(EntityPlayer entityPlayer)
	{
		this.entityPlayer = entityPlayer;
	}

	@Override
	public void onEvent()
	{
		for (Listener listener : Shiberino.getInstance().getEventManager().getUpdateListeners())
		{
			if (listener instanceof Listener)
			{
				Listener module = (Listener) listener;
				module.onPreMotion();
			}
		}
	}
}
