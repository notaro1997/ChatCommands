package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.HideFile;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class HideListener implements Listener{

	private ChatCommands plugin;
	public HideListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event){
		HideFile HideFile = plugin.HiddenPlayers;
		Player player = event.getPlayer();
		String name = player.getName();
		if(HideFile.contains(name)){
			player.sendMessage(ChatColor.RED + "(You are hidden)");
			for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
				if (!onlinePlayer.equals(player)){
					onlinePlayer.hidePlayer(player);
					event.setJoinMessage(null);
				}
			}
		}
	}
}
