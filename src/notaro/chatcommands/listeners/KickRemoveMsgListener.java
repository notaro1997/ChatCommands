package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;

import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class KickRemoveMsgListener implements Listener{

	private ChatCommands plugin;
	public KickRemoveMsgListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onQuitCommand(PlayerKickEvent event){
		Player player = event.getPlayer();
		String name = player.getName();
		if(plugin.KickedPlayers.contains(name)){
			event.setLeaveMessage(null);
		}
	}
}
