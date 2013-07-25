package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor{

	private ChatCommands plugin;
	public Weather(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("weather") && args.length == 1){
			if(player.hasPermission("notaro.weather") || player.hasPermission("notaro.*")){	
				plugin.log.info(player.getName() + ": ChatCommands: WEATHER");
				if(args[0].equalsIgnoreCase("sun")){
					player.getWorld().setStorm(false);
					player.getWorld().setThundering(false);
					player.sendMessage(ChatColor.BLUE + "Setting server weather to " + ChatColor.YELLOW + "Sun");
				}
				if(args[0].equalsIgnoreCase("rain")){
					player.getWorld().setStorm(true);	
					player.sendMessage(ChatColor.BLUE + "Setting server weather to " + ChatColor.YELLOW + "Rain");
				}
				if(args[0].equalsIgnoreCase("storm")){
					player.getWorld().setThundering(true);
					player.sendMessage(ChatColor.BLUE + "Setting server weather to " + ChatColor.YELLOW + "Storm");
				}
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type /weather sun, rain, or storm.");
		}
		return false;
	}
}