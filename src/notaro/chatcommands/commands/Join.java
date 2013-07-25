package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Join implements CommandExecutor{

	private ChatCommands plugin;
	public Join(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("join")){
			if(sender.hasPermission("notaro.join") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: JOIN");
				if(args.length != 0){
					String MSG = args[0];
					for(int i=1; i < args.length; i++) {
						MSG += " " + args[i];
					}
					Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + MSG + " joined the game.");
				}else{
					sender.sendMessage(ChatColor.RED + "Please type some words after /join.");
				}	
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.join " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}