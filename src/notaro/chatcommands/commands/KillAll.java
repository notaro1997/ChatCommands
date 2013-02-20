package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class KillAll implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		String world = player.getWorld().getName();
		if(cmd.getName().equalsIgnoreCase("killall") && sender instanceof Player){
			if(player.hasPermission("notaro.killall") || player.hasPermission("notaro.*")){
				int i = 0;
				for(Entity entity: ((Player)sender).getWorld().getEntities()){
					if(entity instanceof LivingEntity && !(entity instanceof Player)){
						LivingEntity entitys = (LivingEntity)entity;
						if(entitys.getLocation().distance(((Player)sender).getLocation()) > 0){
							entitys.setHealth(0);
							i++;
						}
					}
				}
				((Player)sender).sendMessage(ChatColor.DARK_AQUA + "Killed " + ChatColor.RED + i + ChatColor.DARK_AQUA + " entitys in world: " + ChatColor.RED + world);
			}
		}
		return true;
	}
}