package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("0")){
			if(player.hasPermission("notaro.0") || player.hasPermission("notaro.*")){
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.DARK_AQUA + "You are now in GameMode 0 (Survival)");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.0 " + ChatColor.RED + "to perform this command.");	
			}
		}else if(cmd.getName().equalsIgnoreCase("1")){
			if(player.hasPermission("notaro.1") || player.hasPermission("notaro.*")){
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.DARK_AQUA + "You are now in GameMode 1 (Creative)");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.1 " + ChatColor.RED + "to perform this command.");	
			}   
		}else if(cmd.getName().equalsIgnoreCase("2")){
			if(player.hasPermission("notaro.2") || player.hasPermission("notaro.*")){
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(ChatColor.DARK_AQUA + "You are now in GameMode 2 (Adventure)");
			}

		}else{
			player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.2 " + ChatColor.RED + "to perform this command.");	
		}
		return false;
	}
}