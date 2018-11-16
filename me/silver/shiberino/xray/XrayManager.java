package me.silver.shiberino.xray;

import java.util.ArrayList;

import me.silver.shiberino.Shiberino;
import me.silver.shiberino.module.modules.AutoJump;
import me.silver.shiberino.module.modules.AutoWalk;
import me.silver.shiberino.module.modules.Brightness;
import me.silver.shiberino.module.modules.Flight;
import me.silver.shiberino.module.modules.NoFall;
import me.silver.shiberino.module.modules.Sneak;
import me.silver.shiberino.module.modules.Sprint;
import me.silver.shiberino.module.modules.Step;
import me.silver.shiberino.module.modules.Xray;
import net.minecraft.block.Block;

public class XrayManager
{
	private static ArrayList<Block> blocks = new ArrayList<>();
	private boolean enabled;

	public void initializeBlocks()
	{
		blocks.add(Block.getBlockFromName("gold_ore"));
		blocks.add(Block.getBlockFromName("iron_ore"));
		blocks.add(Block.getBlockFromName("gold_block"));
		blocks.add(Block.getBlockFromName("iron_block"));
		blocks.add(Block.getBlockFromName("tnt"));
		blocks.add(Block.getBlockFromName("mob_spawner"));
		blocks.add(Block.getBlockFromName("chest"));
		blocks.add(Block.getBlockFromName("diamond_ore"));
		blocks.add(Block.getBlockFromName("diamond_block"));
		blocks.add(Block.getBlockFromName("redstone_ore"));
		blocks.add(Block.getBlockFromName("lit_redstone_ore"));
		blocks.add(Block.getBlockFromName("emerald_ore"));
		blocks.add(Block.getBlockFromName("emerald_block"));
	}

	public boolean isXrayEnabled()
	{
		return enabled;
	}

	public void setXrayEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public boolean isXrayBlock(Block block)
	{
		if (blocks.contains(block))
		{
			return true;
		}

		return false;
	}
}
