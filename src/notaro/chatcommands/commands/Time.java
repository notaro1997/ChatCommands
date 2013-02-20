package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("time") && args.length == 1){
			if(player.hasPermission("notaro.time") || player.hasPermission("notaro.*")){
				if(sender instanceof Player){
					if(args.length == 1){
						String time = String.valueOf(args[0]);
						if(time.equalsIgnoreCase("night")){
							player.setPlayerTime(6000, true);
							return true;
						}else{ 
							if (time.equalsIgnoreCase("day")){
								player.setPlayerTime(19000, true);
								return true;
							}else{
								if(time.equalsIgnoreCase("normal")){
									player.resetPlayerTime();
									return true;
								}
							}
						}
					}
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.time " + ChatColor.RED + "to perform this command.");
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Type /time day, night, or normal.");
		}
		return false;
	}
}
