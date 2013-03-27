package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor{

	private ChatCommands plugin;
	public EnderChest(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[0]);
		if(cmd.getName().equalsIgnoreCase("enderchest")){
			if(player.hasPermission("notaro.enderchest") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: ENDERCHEST");
				player.openInventory(target.getEnderChest());	
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.enderchest " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Please specify who's enderchest to view.");
		}
		return false;	
	}
}
