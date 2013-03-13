package notaro.chatcommands.listeners;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener{

	private ChatCommands plugin;
	public PlayerQuitEventListener(ChatCommands plugin){
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		PlayerData PlayerData = plugin.getPlayerData();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		PlayerData.getPlayers().set(player.getName() + ".LastSeen", dateFormat.format(date));
		PlayerData.getPlayers().set(player.getName() + ".World", player.getWorld().getName());
		PlayerData.getPlayers().set(player.getName() + ".Ip", player.getAddress().getHostName());
		PlayerData.getPlayers().set(player.getName() + ".Port", player.getAddress().getPort());
		PlayerData.getPlayers().set(player.getName() + ".Gamemode", player.getGameMode().toString().toLowerCase());
		PlayerData.getPlayers().set(player.getName() + ".Level", player.getLevel());
		if(player.isOp()){
			PlayerData.getPlayers().set(player.getName() + ".Op", true);
		}else{
			PlayerData.getPlayers().set(player.getName() + ".Op", false);	
		}	
		PlayerData.saveData();
	}
}
