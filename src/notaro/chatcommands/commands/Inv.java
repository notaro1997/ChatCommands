package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Inv implements CommandExecutor{

	private ChatCommands plugin;
	public Inv(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("inv") && args.length == 1){  
			if(player.hasPermission("notaro.inv") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: INV");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						player.openInventory(target.getInventory());
					}
				}
			}else{ 
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.inv " + ChatColor.RED + "to perform this command."); 	
			}
		}else{
			player.sendMessage(ChatColor.RED + "Please specify whos inventory to search.");
		}
		return false;
	}
}
