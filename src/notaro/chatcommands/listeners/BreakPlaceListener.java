package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakPlaceListener implements Listener{

	private ChatCommands plugin;
	public BreakPlaceListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	PlayerData playerData = plugin.getPlayerData();
	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockPlace(BlockPlaceEvent event){
		Player player = event.getPlayer();
		int p = playerData.getPlayers().getInt(player.getName() + ".BlocksPlaced");
		playerData.getPlayers().set(player.getName() + ".BlocksPlaced", p + 1);
		playerData.saveData();		
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		int b = playerData.getPlayers().getInt(player.getName() + ".BlocksBroken");
		playerData.getPlayers().set(player.getName() + ".BlocksBroken", b + 1);
		playerData.saveData();		
	}
}
