package notaro.chatcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ban")){
			if(sender.hasPermission("notaro.ban") || player.hasPermission("notaro.*")){
				if(sender instanceof Player){
					if(args.length != 0){
						int i = 1;
						int para = args.length;
						String MSG = "";
						while(i < para){
							MSG = MSG + " " + args[i];
							i++;
						}
						Player target = Bukkit.getPlayer(args[0]);
						target.setBanned(true);
						target.kickPlayer(ChatColor.DARK_RED + "BANNED!" + ChatColor.AQUA + " Reason: " + ChatColor.RED + MSG);
						Bukkit.getServer().broadcastMessage(ChatColor.RED + target.getName() + " has been banned by " + player.getName());
					}
				}else{
					player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.ban " + ChatColor.RED + "to perform this command.");
				}
			}
		}
		return false;
	}
}
