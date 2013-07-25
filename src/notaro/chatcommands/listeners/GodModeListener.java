package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class GodModeListener implements Listener{

	private ChatCommands plugin;
	public GodModeListener(ChatCommands plugin){
		this.plugin = plugin;
	}


	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			PlayerData playerData = plugin.getPlayerData();
			String godmode = playerData.getPlayers().getString(player.getName() + ".God");
			if(godmode.equals("true")){
				event.setCancelled(true);
			}
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onFoodLevelChange(FoodLevelChangeEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			PlayerData playerData = plugin.getPlayerData();
			String godmode = playerData.getPlayers().getString(player.getName() + ".God");
			if(godmode.equals("true")){
				event.setCancelled(true);	
			}
		}
	}
}