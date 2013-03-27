package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class World implements CommandExecutor{

	private ChatCommands plugin;
	public World(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}

		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("world") && args.length == 1){
			if(player.hasPermission("notaro.world") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: WORLD");
				Location location = Bukkit.getWorld(args[0]).getSpawnLocation();
				player.teleport(location);
				player.sendMessage(ChatColor.YELLOW + "Teleported to world " + args[0]);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.world " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type: /world World_Name");
		}
		return false;	
	}
}