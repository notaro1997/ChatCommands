package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.HideFile;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hide implements CommandExecutor {
	private ChatCommands plugin;
	public Hide(ChatCommands plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		} 
		Player player = (Player) sender;		
		HideFile HideFile = plugin.HiddenPlayers;
		String name = player.getName();
		if(cmd.getName().equalsIgnoreCase("hide")){
			if(player.hasPermission("notaro.hide") || player.hasPermission("notaro.*")){	
				HideFile.add(name);
				HideFile.saveData();
				player.sendMessage(ChatColor.DARK_AQUA + "You are now being hidden from other players. (Tab menu, ect.)");
				for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
					if (!onlinePlayer.equals(player)){
						onlinePlayer.hidePlayer(player);
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.hide " + ChatColor.RED + "to perform this command.");
			}
		} 
		else if(cmd.getName().equalsIgnoreCase("show")){
			if(player.hasPermission("notaro.show") || player.hasPermission("notaro.*")){
				player.sendMessage(ChatColor.DARK_AQUA + "You are now visible to other players. (Tab menu, ect.)");
				HideFile.remove(name);
				HideFile.saveData();
				for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()){
					if (!onlinePlayer.equals(player)){					
						onlinePlayer.showPlayer(player);
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.show " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}
