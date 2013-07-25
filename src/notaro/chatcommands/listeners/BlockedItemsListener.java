package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.BlockFile;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class BlockedItemsListener implements Listener{

	private ChatCommands plugin;
	public BlockedItemsListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onMobSpawn(CreatureSpawnEvent event){
		BlockFile blockFile = plugin.BlockedItems;
		if(blockFile.contains("mobs")){
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		BlockFile blockFile = plugin.BlockedItems;
		Player player = event.getPlayer();
		Block block = event.getBlock();
		if(!player.isOp()){
			if(blockFile.contains(block.getType().toString().toLowerCase())){
				player.sendMessage(ChatColor.RED + event.getBlock().getType().toString().toLowerCase().replace("_", " ") + " is blocked on this server!");
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		BlockFile blockFile = plugin.BlockedItems;
		Player player = event.getPlayer();
		Block block = event.getBlock();
		if(!player.isOp()){
			if(blockFile.contains(block.getType().toString().toLowerCase())){
				player.sendMessage(ChatColor.RED + event.getBlock().getType().toString().toLowerCase().replace("_", " ") + " is blocked on this server!");
				event.setCancelled(true);
			}
		}
	}
}
