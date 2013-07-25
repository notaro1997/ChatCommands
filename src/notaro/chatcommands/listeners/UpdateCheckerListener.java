package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdateCheckerListener implements Listener{

	private ChatCommands plugin;
	public UpdateCheckerListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(player.isOp()){
			if (plugin.updateChecker.ChatCommandsUpdateNeeded()){
				if(plugin.getServerData.contains("UpdateChecker_True")){
					player.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.DARK_RED + "ChatCommands" + ChatColor.DARK_GREEN + "] " + ChatColor.DARK_PURPLE + "Update avalable! Get it here:");
					player.sendMessage(ChatColor.DARK_BLUE + "http://dev.bukkit.org/server-mods/chatcommands/");
				}
			}
		}
	}
}