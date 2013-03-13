package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor{

	private ChatCommands plugin;
	public Info(ChatCommands instance){
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		PlayerData PlayerData = plugin.getPlayerData();
		if(cmd.getName().equalsIgnoreCase("info") && args.length == 1){
			if(player.hasPermission("notaro.info") || player.hasPermission("notaro.*")){
				String target = String.valueOf(args[0]);
				if(PlayerData.getPlayers().contains(target)){
					String world = PlayerData.getPlayers().getString(target + ".World");
					String ip = PlayerData.getPlayers().getString(target + ".Ip");
					int port = PlayerData.getPlayers().getInt(target + ".Port");
					String gamemode = PlayerData.getPlayers().getString(target + ".Gamemode");
					String level = PlayerData.getPlayers().getString(target + ".Level");
					String joindate = PlayerData.getPlayers().getString(target + ".JoinDate");
					String lastseen = PlayerData.getPlayers().getString(target + ".LastSeen");
					String op = PlayerData.getPlayers().getString(target + ".Op");
					int kicked = PlayerData.getPlayers().getInt(target + ".Kicked");
					player.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Info for " + target + ChatColor.GOLD + " *******");
					player.sendMessage(ChatColor.DARK_GREEN + "Username: " + ChatColor.AQUA + target);
					player.sendMessage(ChatColor.DARK_GREEN + "World: " + ChatColor.AQUA + world);
					player.sendMessage(ChatColor.DARK_GREEN + "IP: " + ChatColor.AQUA + ip);
					player.sendMessage(ChatColor.DARK_GREEN + "Port: " + ChatColor.AQUA + port);
					player.sendMessage(ChatColor.DARK_GREEN + "Gamemode: " + ChatColor.AQUA + gamemode);
					player.sendMessage(ChatColor.DARK_GREEN + "Level: " + ChatColor.AQUA + level);
					player.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + op);
					if(!(lastseen == null)){
						player.sendMessage(ChatColor.DARK_GREEN + "Last Seen: " + ChatColor.AQUA + lastseen);
					}else{
						player.sendMessage(ChatColor.DARK_GREEN + "Last Seen: " + ChatColor.AQUA + "Today, or unknown.");
					}
					player.sendMessage(ChatColor.DARK_GREEN + "Join Date: " + ChatColor.AQUA + joindate);
					player.sendMessage(ChatColor.DARK_GREEN + "Kicked: " + ChatColor.AQUA + kicked + " time(s)");
				}else{
					player.sendMessage(ChatColor.RED + "That player is not in any server records.");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.info " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Please specify who's info to view.");
		}
		return false;	
	}
}
