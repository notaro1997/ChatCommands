package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener{

	@SuppressWarnings("unused")
	private ChatCommands plugin;
	public PlayerQuitEventListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onQuit(PlayerQuitEvent event){
		
	}
}
