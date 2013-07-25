package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;

public class Time implements CommandExecutor{

	private ChatCommands plugin;
	public Time(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("time")){
			if(player.hasPermission("notaro.time") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: TIME");
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("night")){
						player.resetPlayerTime();
						player.setPlayerTime(19000, false);
						player.sendMessage(ChatColor.BLUE + "Setting player time to " + ChatColor.YELLOW + "Night");
						return true;
					}else if (args[0].equalsIgnoreCase("day")){
						player.resetPlayerTime();
						player.setPlayerTime(6000, false);
						player.sendMessage(ChatColor.BLUE + "Setting player time to " + ChatColor.YELLOW + "Day");
						return true;
					}else if(args[0].equalsIgnoreCase("normal")){
						player.resetPlayerTime();
						player.sendMessage(ChatColor.BLUE + "Setting player time to " + ChatColor.YELLOW + "Server time");
						return true;
					}
				}
				if(args.length == 2){
					if(args[0].equalsIgnoreCase("server")){
						int time = 0;
						if(args[1].equalsIgnoreCase("day")){
							time = 6000;
							player.sendMessage(ChatColor.BLUE + "Setting server time to " + ChatColor.YELLOW + "Day");
						}else if(args[1].equalsIgnoreCase("night")){
							time = 19000;
							player.sendMessage(ChatColor.BLUE + "Setting server time to " + ChatColor.YELLOW + "Night");
						}
						for(World world : Bukkit.getWorlds()){
							world.setTime(time);
						}
					}
				}
				if(args.length > 2 || args.length < 1 || args[0].equals("set")){
					player.sendMessage(ChatColor.RED + "Type /time day, night, normal, or server day, server night.");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.time " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
