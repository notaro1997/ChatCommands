package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Satan implements CommandExecutor{

	private ChatCommands plugin;
	public Satan(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("satan")){
			if(player.hasPermission("notaro.satan") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SATAN");
				if(args.length != 0){
					String MSG = args[0];
					for(int i=1; i < args.length; i++) {
						MSG += " " + args[i];
					}
					Bukkit.getServer().broadcastMessage(ChatColor.WHITE + "<" + ChatColor.RED + "SATAN" + ChatColor.WHITE + "> " + ChatColor.LIGHT_PURPLE + MSG);
				}else{
					player.sendMessage(ChatColor.RED + "Please specify what to say");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.satan " + ChatColor.RED + "to perform this command."); 
			}
		}
		return true;
	}
}