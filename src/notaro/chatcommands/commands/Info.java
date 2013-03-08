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
				int I = PlayerData.getPlayers().getInt(target.getName() + ".Kicked");
				player.sendMessage(ChatColor.GOLD + "******* " + ChatColor.DARK_PURPLE + "Info for " + target.getName() + ChatColor.GOLD + " *******");
				player.sendMessage(ChatColor.DARK_GREEN + "Player: " + ChatColor.AQUA + target.getName());
				player.sendMessage(ChatColor.DARK_GREEN + "World: " + ChatColor.AQUA + target.getWorld().getName());
				player.sendMessage(ChatColor.DARK_GREEN + "IP: " + ChatColor.AQUA + target.getAddress().getHostName());
				player.sendMessage(ChatColor.DARK_GREEN + "Port: " + ChatColor.AQUA + target.getAddress().getPort());
				player.sendMessage(ChatColor.DARK_GREEN + "Gamemode: " + ChatColor.AQUA + target.getGameMode());
				player.sendMessage(ChatColor.DARK_GREEN + "Level: " + ChatColor.AQUA + target.getLevel());
				player.sendMessage(ChatColor.DARK_GREEN + "Kicked: " + ChatColor.AQUA + I + " time(s)");
				if(!target.isOp()){
					player.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + "False");
				}else{
					player.sendMessage(ChatColor.DARK_GREEN + "Op: " + ChatColor.AQUA + "True");
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
