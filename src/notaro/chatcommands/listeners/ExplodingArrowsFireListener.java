package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ExplodingArrowsFireListener implements Listener{

	private ChatCommands plugin;
	public ExplodingArrowsFireListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityShootBow(EntityShootBowEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof Arrow) {
			Arrow arrow = (Arrow) entity;
			Entity shooter = arrow.getShooter();

			if (shooter instanceof Player) {
				Player player = (Player) shooter;
				if (player.hasPermission("notaro.ea") || player.hasPermission("notaro.*")){
					if (plugin.enabledPlayers.contains(player.getName())){
						arrow.setFireTicks(1000); 
					}
				}
			}
		}
	}
}
