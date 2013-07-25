package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class KillAll implements CommandExecutor{

	private ChatCommands plugin;
	public KillAll(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		String world = player.getWorld().getName();
		if(cmd.getName().equalsIgnoreCase("killall") && sender instanceof Player){
			if(player.hasPermission("notaro.killall") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: KILLALL");
				int i = 0;
				for(Entity entity: player.getWorld().getEntities()){
					if(entity instanceof LivingEntity && !(entity instanceof Player)){
						LivingEntity entitys = (LivingEntity)entity;
						entitys.setHealth(0);
						i++;	
					}
				}
				player.sendMessage(ChatColor.DARK_AQUA + "Killed " + ChatColor.RED + i + ChatColor.DARK_AQUA + " entitys in world: " + ChatColor.RED + world);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.killall " + ChatColor.RED + "to perform this command.");
			}
		}
		return true;
	}
}