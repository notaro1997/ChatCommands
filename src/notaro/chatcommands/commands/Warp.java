package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.WarpFile;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp implements CommandExecutor{

	private ChatCommands plugin;
	public Warp(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		WarpFile warps = plugin.getWarpData();
		if(cmd.getName().equalsIgnoreCase("warp") && args.length >= 1){
			if(player.hasPermission("notaro.warp") || player.hasPermission("notaro.*")){
				if(args.length == 1){
					String warp = String.valueOf(args[0].toLowerCase());
					if(warps.getWarps().contains(warp)){
						String world = warps.getWarps().getString(warp + ".world");
						int x = warps.getWarps().getInt(warp + ".x");
						int y = warps.getWarps().getInt(warp + ".y");
						int z = warps.getWarps().getInt(warp + ".z");
						float yaw = warps.getWarps().getInt(warp + ".yaw");
						float pitch = warps.getWarps().getInt(warp + ".pitch");
						Location location = new Location(Bukkit.getWorld(world), x + 0.5, y, z + 0.5, yaw, pitch);
						player.sendMessage(ChatColor.DARK_AQUA + "You successfully warped to " + ChatColor.YELLOW + warp);
						player.teleport(location);
						return true;
					}else{
						player.sendMessage(ChatColor.RED + "The warp " + ChatColor.YELLOW + warp + ChatColor.RED + " does not exist.");
					}
				}else{
					player.sendMessage(ChatColor.RED + "Please specify where to warp.");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.warp " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}
