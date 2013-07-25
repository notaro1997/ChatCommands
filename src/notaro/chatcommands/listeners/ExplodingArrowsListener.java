package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ExplodingArrowsListener implements Listener{

	private ChatCommands plugin;
	public ExplodingArrowsListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onProjectileHit(ProjectileHitEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Arrow) {
			Arrow arrow = (Arrow) entity;
			Entity shooter = arrow.getShooter();
			if (shooter instanceof Player) {
				Player player = (Player) shooter;
				if (player.hasPermission("notaro.ea") || player.hasPermission("notaro.*")){
					if (plugin.explodingArrowsPlayers.contains(player.getName())){
						player.getWorld().createExplosion(arrow.getLocation(), 6F);
					}
				}
			}
		}
	}
}
