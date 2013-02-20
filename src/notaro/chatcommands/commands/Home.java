package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.HomeFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor{

	private ChatCommands plugin;
	public Home(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("home")){
			HomeFile Homes = plugin.getHomeData();
			if(player.hasPermission("notaro.warp") || player.hasPermission("notaro.*")){
					String Name = player.getName();
					if(Homes.getHome().contains(Name)){
						String world = Homes.getHome().getString(Name + ".world");
						int x = Homes.getHome().getInt(Name + ".x");
						int y = Homes.getHome().getInt(Name + ".y");
						int z = Homes.getHome().getInt(Name + ".z");
						float yaw = Homes.getHome().getInt(Name + ".yaw");
						float pitch = Homes.getHome().getInt(Name + ".pitch");
						Location location = new Location(Bukkit.getWorld(world), x + 0.5, y, z + 0.5, yaw, pitch);
						player.sendMessage(ChatColor.YELLOW + "Welcome home!");
						player.teleport(location);
						return true;
					}else{
						player.sendMessage(ChatColor.YELLOW + "You dont have a home set.");
					}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.warp " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}
