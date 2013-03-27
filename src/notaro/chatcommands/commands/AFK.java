package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Afk implements CommandExecutor{

	private ChatCommands plugin;
	public Afk(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("afk")){
			if(player.hasPermission("notaro.afk") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: AFK");
				Bukkit.getServer().broadcastMessage(player.getDisplayName() + ChatColor.RED + " is now " + "AFK"); 
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.afk " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}