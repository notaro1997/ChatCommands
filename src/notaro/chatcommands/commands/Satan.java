package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Satan implements CommandExecutor{

	private ChatCommands plugin;
	public Satan(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("satan")){
			if(sender.hasPermission("notaro.satan") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: SATAN");
				if(args.length != 0){
					String MSG = args[0];
					for(int i=1; i < args.length; i++) {
						MSG += " " + args[i];
					}
					Bukkit.getServer().broadcastMessage(ChatColor.WHITE + "<" + ChatColor.RED + "SATAN" + ChatColor.WHITE + "> " + ChatColor.LIGHT_PURPLE + MSG);
				}else{
					sender.sendMessage(ChatColor.RED + "Please specify what to say");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.satan " + ChatColor.RED + "to perform this command."); 
			}
		}
		return true;
	}
}