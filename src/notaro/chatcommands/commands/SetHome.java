package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.HomeFile;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor{

	private ChatCommands plugin;
	public SetHome(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("sethome")){
			plugin.log.info(player.getName() + ": ChatCommands: SETHOME");
			HomeFile homes = plugin.getHomeData();
			Location location = player.getLocation();
			int x = location.getBlockX();
			int y = location.getBlockY();
			int z = location.getBlockZ();
			float yaw = location.getYaw();
			float pitch = location.getPitch();
			String world = location.getWorld().getName();
			if(player.hasPermission("notaro.sethome") || player.hasPermission("notaro.*")){
				String Name = player.getName();
				homes.getHome().set(Name + ".world", world);
				homes.getHome().set(Name + ".x", x);
				homes.getHome().set(Name + ".y", y);
				homes.getHome().set(Name + ".z", z);
				homes.getHome().set(Name + ".yaw", yaw);
				homes.getHome().set(Name + ".pitch", pitch);
				homes.saveData();
				homes.reloadData();
				player.sendMessage(ChatColor.YELLOW + "Home set!");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.sethome " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}