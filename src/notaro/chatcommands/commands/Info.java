package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.Bukkit;
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
				Player target = Bukkit.getPlayer(args[0]);
				if(!(target == null)){
					String targetName = target.getName();
					int kicked = PlayerData.getPlayers().getInt(targetName + ".Kicked");  
					String joindate = PlayerData.getPlayers().getString(targetName + ".JoinDate");
					String lastseen = PlayerData.getPlayers().getString(targetName + ".LastSeen");

					player.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Info for " + targetName + ChatColor.GOLD + " *******");
					player.sendMessage(ChatColor.DARK_GREEN + "Username: " + ChatColor.AQUA + targetName);
					player.sendMessage(ChatColor.DARK_GREEN + "World: " + ChatColor.AQUA + target.getWorld().getName());
					player.sendMessage(ChatColor.DARK_GREEN + "IP: " + ChatColor.AQUA + target.getAddress());
					player.sendMessage(ChatColor.DARK_GREEN + "Port: " + ChatColor.AQUA + target.getAddress().getPort());
					player.sendMessage(ChatColor.DARK_GREEN + "Gamemode: " + ChatColor.AQUA + target.getGameMode().toString().toLowerCase());
					player.sendMessage(ChatColor.DARK_GREEN + "Level: " + ChatColor.AQUA + target.getLevel());
					if(target.isOp()){
						player.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + "True");
					}else{
						player.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + "False");
					}
					if(!(lastseen == null)){
						player.sendMessage(ChatColor.DARK_GREEN + "Last Seen: " + ChatColor.AQUA + lastseen);
					}else{
						player.sendMessage(ChatColor.DARK_GREEN + "Last Seen: " + ChatColor.AQUA + "Today, or unknown.");
					}
					player.sendMessage(ChatColor.DARK_GREEN + "Join Date: " + ChatColor.AQUA + joindate);
					player.sendMessage(ChatColor.DARK_GREEN + "Kicked: " + ChatColor.AQUA + kicked + " time(s)");
					
				}else{
					if(PlayerData.getPlayers().contains(args[0])){
						String world = PlayerData.getPlayers().getString(args[0] + ".World");        
						String ip = PlayerData.getPlayers().getString(args[0] + ".Ip");
						int port = PlayerData.getPlayers().getInt(args[0] + ".Port");
						String gamemode = PlayerData.getPlayers().getString(args[0] + ".Gamemode");
						String level = PlayerData.getPlayers().getString(args[0] + ".Level");
						String joindate = PlayerData.getPlayers().getString(args[0] + ".JoinDate");
						String lastseen = PlayerData.getPlayers().getString(args[0] + ".LastSeen");
						String op = PlayerData.getPlayers().getString(args[0] + ".Op");
						int kicked = PlayerData.getPlayers().getInt(args[0] + ".Kicked");  

						player.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Info for " + args[0] + ChatColor.GOLD + " *******");
						player.sendMessage(ChatColor.DARK_GREEN + "Username: " + ChatColor.AQUA + args[0]);
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
						player.sendMessage(ChatColor.RED + "There are no server records for " + args[0]);
					}
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