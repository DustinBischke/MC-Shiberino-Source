package me.silver.shiberino.event.events;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.event.Event;
import me.silver.shiberino.event.Listener;

public class EventKeyPress implements Event
{
	private int keyCode;

	public EventKeyPress(int keyCode)
	{
		this.keyCode = keyCode;
	}

	@Override
	public void onEvent()
	{
		for (Listener listener : Shiberino.getInstance().getEventManager().getModuleListeners())
		{
			if (listener instanceof Listener)
			{
				Listener module = listener;
				module.onKeyPress(keyCode);
			}
		}
	}
}
