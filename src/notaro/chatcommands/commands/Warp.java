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
		if(cmd.getName().equalsIgnoreCase("warp")){
			WarpFile warps = plugin.getWarpData();
			if(player.hasPermission("notaro.warp") || player.hasPermission("notaro.*")){
				if(args.length == 1){
					String Warp = String.valueOf(args[0].toLowerCase());
					if(warps.getWarps().contains(Warp)){
						String world = warps.getWarps().getString(Warp + ".world");
						int x = warps.getWarps().getInt(Warp + ".x");
						int y = warps.getWarps().getInt(Warp + ".y");
						int z = warps.getWarps().getInt(Warp + ".z");
						float yaw = warps.getWarps().getInt(Warp + ".yaw");
						float pitch = warps.getWarps().getInt(Warp + ".pitch");
						Location location = new Location(Bukkit.getWorld(world), x + 0.5, y, z + 0.5, yaw, pitch);
						player.sendMessage(ChatColor.DARK_AQUA + "you successfully wapped to: " + ChatColor.YELLOW + Warp);
						player.teleport(location);
						return true;
					}else{
						player.sendMessage(ChatColor.DARK_AQUA + "The warp " + ChatColor.YELLOW + Warp + ChatColor.DARK_AQUA + " does not exist.");
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
