package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hug implements CommandExecutor{

	private ChatCommands plugin;
	public Hug(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("hug")){   
			if(player.hasPermission("notaro.hug") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: HUG");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.YELLOW + " received a " + ChatColor.LIGHT_PURPLE + "hug " + ChatColor.YELLOW + "from " + ChatColor.YELLOW + player.getDisplayName());
				}else{
					Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "You just got a " + ChatColor.LIGHT_PURPLE + "hug " + ChatColor.YELLOW + "from " + ChatColor.YELLOW + player.getName());
				}
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.hug " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
