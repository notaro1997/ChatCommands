package notaro.chatcommands.listeners;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnEggListener implements Listener {

	private ChatCommands plugin;
	public SpawnEggListener(ChatCommands plugin){
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onSpawnEgg(PlayerInteractEvent event){
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) return;
		Player player = event.getPlayer();
		Location loc = player.getTargetBlock(null, 15).getLocation().add(0, 2, 0);
		if(plugin.spawnEggPlayers.contains(player.getName())){
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.MONSTER_EGG){
				player.getWorld().spawnEntity(loc, EntityType.fromName("COW"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("CHICKEN"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("CHICKEN"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("WOLF"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("WOLF"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SHEEP"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("PIG"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SNOWMAN"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SQUID"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("CREEPER"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SPIDER"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("CAVESPIDER"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("CAVESPIDER"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("ENDERMAN"));
				player.getWorld().spawnEntity(loc, EntityType.MAGMA_CUBE);
				player.getWorld().spawnEntity(loc, EntityType.fromName("MUSHROOMCOW"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("MUSHROOMCOW"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("PIGZOMBIE"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("PIGZOMBIE"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SILVERFISH"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SILVERFISH"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SILVERFISH"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SKELETON"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SKELETON"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("SLIME"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("ZOMBIE"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("BAT"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("BAT"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("BAT"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("BAT"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("WITCH"));
				player.getWorld().spawnEntity(loc, EntityType.fromName("WITCH"));
				player.getWorld().spawnEntity(loc, EntityType.OCELOT);
				player.getWorld().spawnEntity(loc, EntityType.OCELOT);
				player.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
			}
		}
	}
}
