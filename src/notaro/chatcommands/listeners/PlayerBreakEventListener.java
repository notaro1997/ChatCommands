package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakEventListener implements Listener{

	private ChatCommands plugin;
	public PlayerBreakEventListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent event){
		PlayerData playerData = plugin.getPlayerData();
		Player player = event.getPlayer();
		int b = playerData.getPlayers().getInt(player.getName() + ".BlocksBroken");
		playerData.getPlayers().set(player.getName() + ".BlocksBroken", b + 1);
		playerData.saveData();		
	}
}
