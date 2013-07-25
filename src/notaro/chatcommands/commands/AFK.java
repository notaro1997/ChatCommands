package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Afk implements CommandExecutor{

	private ChatCommands plugin;
	public Afk(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("afk")){
			if(sender.hasPermission("notaro.afk") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: AFK");
				Bukkit.getServer().broadcastMessage(ChatColor.RED + sender.getName() + " is now " + "AFK"); 
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.afk " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}