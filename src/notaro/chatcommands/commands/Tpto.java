package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpto implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tpto") && args.length == 3){
			if(player.hasPermission("notaro.tpto") || player.hasPermission("notaro.*")){
				int X = Integer.parseInt(args[0]);
				int Y = Integer.parseInt(args[1]);
				int Z = Integer.parseInt(args[2]);
				player.sendMessage(ChatColor.DARK_AQUA + "You were teleported to " + ChatColor.YELLOW + X + " " + Y + " " + Z );
				Location location = new Location(player.getWorld(), X + 0.5, Y, Z + 0.5);
				player.teleport(location);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.tpto " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type: /tpto X Y Z");
		}
		return false;	
	}
}