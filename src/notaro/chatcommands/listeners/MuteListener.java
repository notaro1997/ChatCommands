package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.MuteFile;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MuteListener implements Listener{

	private ChatCommands plugin;
	public MuteListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void AsyncPlayerChatEvent(AsyncPlayerChatEvent event){
		MuteFile MuteFile = plugin.MutedPlayers;
		Player player = event.getPlayer();
		String name = player.getName();
		if(MuteFile.contains(name)){
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You are Muted. No one saw that.");
		}
	}
}
