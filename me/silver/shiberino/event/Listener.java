package me.silver.shiberino.event;

import me.silver.shiberino.event.events.EventOnUpdate;

public interface Listener
{
	void onUpdate();

	void onPreMotion();

	void onPostMotion();

	void onKeyPress(int keyCode);
}
