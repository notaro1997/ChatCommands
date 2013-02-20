package notaro.chatcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Who implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("who")){
			if(player.hasPermission("notaro.who") || player.hasPermission("notaro.*")){
				if(args.length == 0){
					StringBuilder players = new StringBuilder();
					for(Player online : Bukkit.getOnlinePlayers()){
						if(!player.canSee(online)){ 
							continue;
						}
						if(players.length() > 0){
							players.append(ChatColor.DARK_PURPLE + ", " + ChatColor.YELLOW);
						}
						players.append(online.getDisplayName());
					}
					player.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Online Players" + ChatColor.GOLD + " *******");
					player.sendMessage(ChatColor.DARK_AQUA + "Player(s) online: " + ChatColor.RED + Bukkit.getOnlinePlayers().length);
					player.sendMessage(ChatColor.YELLOW  + players.toString());
					
				}else{
					player.sendMessage(ChatColor.AQUA + "Type /who.");
				}
				
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.who " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}