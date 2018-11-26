package me.silver.shiberino.gui.interfaces;

public interface Draggable
{
	void onDrag(int mouseX, int mouseY);

	void setDragOffsetX(int dragOffsetX);

	void setDragOffsetY(int dragOffsetX);

	boolean isDragging();

	void setDragging(boolean dragging);
}
