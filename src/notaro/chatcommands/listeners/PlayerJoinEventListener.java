package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventListener implements Listener{

	private ChatCommands plugin;
	public PlayerJoinEventListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		plugin.HiddenPlayers.loadData();
		player.sendMessage("Its working.");
	}
}
