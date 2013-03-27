package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Quit implements CommandExecutor{

	private ChatCommands plugin;
	public Quit(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("quit") && args.length < 15){
			if(player.hasPermission("notaro.quit") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: QUIT");
				if(args.length != 0){
					int i = 0;
					int para = args.length; 
					String MSG = "";
					while(i < para){
						MSG = MSG + " " + args[i];
						i++;
					}
					plugin.KickedPlayers.add(player.getName());
					Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + player.getDisplayName() + " quit - " + ChatColor.YELLOW + MSG); 
					player.kickPlayer(ChatColor.DARK_AQUA + "Goodbye.");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.quit " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Your quit msg must be less then 15 words.");
		}
		return false;	
	}
}