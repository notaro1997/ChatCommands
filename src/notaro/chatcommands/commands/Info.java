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
	public Info(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		PlayerData playerData = plugin.getPlayerData();
		if(cmd.getName().equalsIgnoreCase("info") && args.length == 1){
			if(sender.hasPermission("notaro.info") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: INFO");
				Player target = Bukkit.getPlayer(args[0]); // Physical player for online access
				// if the player isn't null, aka if the player is online.
				if(!(target == null)){ 
					String targetName = target.getName(); // Name of the physical player
					int kicked = playerData.getPlayers().getInt(targetName + ".Kicked"); 
					int broken = playerData.getPlayers().getInt(targetName + ".BlocksBroken");
					int placed = playerData.getPlayers().getInt(targetName + ".BlocksPlaced");
					String joindate = playerData.getPlayers().getString(targetName + ".JoinDate");
					String lastseen = playerData.getPlayers().getString(targetName + ".LastSeen");
					String godmode = playerData.getPlayers().getString(targetName + ".God");
					// Messages that are sent to the command sender directly from the online player.
					sender.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Info for " + targetName + ChatColor.GOLD + " *******");
					sender.sendMessage(ChatColor.DARK_GREEN + "Username: " + ChatColor.AQUA + targetName);
					sender.sendMessage(ChatColor.DARK_GREEN + "World: " + ChatColor.AQUA + target.getWorld().getName());
					sender.sendMessage(ChatColor.DARK_GREEN + "IP/Hostname: " + ChatColor.AQUA + target.getAddress().getHostName());
					sender.sendMessage(ChatColor.DARK_GREEN + "Port: " + ChatColor.AQUA + target.getAddress().getPort());
					sender.sendMessage(ChatColor.DARK_GREEN + "Gamemode: " + ChatColor.AQUA + target.getGameMode().toString().toLowerCase());
					sender.sendMessage(ChatColor.DARK_GREEN + "Level: " + ChatColor.AQUA + target.getLevel());
					sender.sendMessage(ChatColor.DARK_GREEN + "Last Seen: " + ChatColor.AQUA + lastseen);
					sender.sendMessage(ChatColor.DARK_GREEN + "Join Date: " + ChatColor.AQUA + joindate);
					sender.sendMessage(ChatColor.DARK_GREEN + "Kicked: " + ChatColor.AQUA + kicked + " time(s)");
					sender.sendMessage(ChatColor.DARK_GREEN + "Blocks broken: " + ChatColor.AQUA + broken);
					sender.sendMessage(ChatColor.DARK_GREEN + "Blocks placed: " + ChatColor.AQUA + placed);
					sender.sendMessage(ChatColor.DARK_GREEN + "God mode: " + ChatColor.AQUA + godmode);
					if(target.isOp()){
						sender.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + "True");
					}else{
						sender.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + "False");
					}
				}else{
					if(playerData.getPlayers().contains(args[0])){ //args[0] is the offline player.
						// Data for offline players \/ Data is resaved everytime the player logs on and off.
						String world = playerData.getPlayers().getString(args[0] + ".World");        
						String ip = playerData.getPlayers().getString(args[0] + ".Ip");
						int port = playerData.getPlayers().getInt(args[0] + ".Port");
						String gamemode = playerData.getPlayers().getString(args[0] + ".Gamemode");
						String level = playerData.getPlayers().getString(args[0] + ".Level");
						String joindate = playerData.getPlayers().getString(args[0] + ".JoinDate");
						String lastseen = playerData.getPlayers().getString(args[0] + ".LastSeen");
						String godmode = playerData.getPlayers().getString(args[0] + ".God");
						String op = playerData.getPlayers().getString(args[0] + ".Op");
						int kicked = playerData.getPlayers().getInt(args[0] + ".Kicked"); 
						int broken = playerData.getPlayers().getInt(args[0] + ".BlocksBroken");
						int placed = playerData.getPlayers().getInt(args[0] + ".BlocksPlaced");
						// Messages sent to the player of data for an offline player.
						sender.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Info for " + args[0] + ChatColor.GOLD + " *******");
						sender.sendMessage(ChatColor.DARK_GREEN + "Username: " + ChatColor.AQUA + args[0]);
						sender.sendMessage(ChatColor.DARK_GREEN + "World: " + ChatColor.AQUA + world);
						sender.sendMessage(ChatColor.DARK_GREEN + "IP/Hostname: " + ChatColor.AQUA + ip);
						sender.sendMessage(ChatColor.DARK_GREEN + "Port: " + ChatColor.AQUA + port);
						sender.sendMessage(ChatColor.DARK_GREEN + "Gamemode: " + ChatColor.AQUA + gamemode);
						sender.sendMessage(ChatColor.DARK_GREEN + "Level: " + ChatColor.AQUA + level);
						sender.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + op);
						sender.sendMessage(ChatColor.DARK_GREEN + "Last Seen: " + ChatColor.AQUA + lastseen); 
						sender.sendMessage(ChatColor.DARK_GREEN + "Join Date: " + ChatColor.AQUA + joindate);
						sender.sendMessage(ChatColor.DARK_GREEN + "Kicked: " + ChatColor.AQUA + kicked + " time(s)");
						sender.sendMessage(ChatColor.DARK_GREEN + "Blocks broken: " + ChatColor.AQUA + broken);
						sender.sendMessage(ChatColor.DARK_GREEN + "Blocks placed: " + ChatColor.AQUA + placed);
						sender.sendMessage(ChatColor.DARK_GREEN + "God mode: " + ChatColor.AQUA + godmode);
					}else{
						sender.sendMessage(ChatColor.RED + "There are no server records for " + args[0]);
						// if the player has never been on the server, while ChatCommands has been installed.
					}
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.info " + ChatColor.RED + "to perform this command.");	
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Please specify who's info to view.");
			// no player was specified (args[0])
		}
		return false;
	}
}