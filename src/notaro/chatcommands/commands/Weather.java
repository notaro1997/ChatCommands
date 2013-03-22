package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("weather") && args.length == 1){
			if(player.hasPermission("notaro.weather") || player.hasPermission("notaro.*")){	
				if(args[0].equalsIgnoreCase("sun")){
					player.getWorld().setStorm(false);
					player.getWorld().setThundering(false);
				}
				if(args[0].equalsIgnoreCase("rain")){
					player.getWorld().setStorm(true);	
				}
				if(args[0].equalsIgnoreCase("storm")){
					player.getWorld().setThundering(true);
				}
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type /weather sun, rain, or storm.");
		}
		return false;
	}
}