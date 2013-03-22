package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceEventListener implements Listener{

	private ChatCommands plugin;
	public PlayerPlaceEventListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockPlace(BlockPlaceEvent event){
		PlayerData playerData = plugin.getPlayerData();
		Player player = event.getPlayer();
		int p = playerData.getPlayers().getInt(player.getName() + ".BlocksPlaced");
		playerData.getPlayers().set(player.getName() + ".BlocksPlaced", p + 1);
		playerData.saveData();		
	}
}
