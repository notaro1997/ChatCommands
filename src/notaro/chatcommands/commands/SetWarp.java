package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.WarpFile;

public class SetWarp implements CommandExecutor{

	private ChatCommands plugin;
	public SetWarp(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setwarp")){
			WarpFile warps = plugin.getWarpData();
			Location location = player.getLocation();
			int x = location.getBlockX();
			int y = location.getBlockY();
			int z = location.getBlockZ();
			float yaw = location.getYaw();
			float pitch = location.getPitch();
			String world = location.getWorld().getName();
			if(player.hasPermission("notaro.setwarp") || player.hasPermission("notaro.*")){
				if(args.length == 1){
					String Warp = String.valueOf(args[0].toLowerCase());
					if(warps.getWarps().contains(Warp)){
						player.sendMessage(ChatColor.RED + "The warp " + ChatColor.YELLOW +  Warp + ChatColor.RED + " already exists.");
						return true;
					}
					warps.getWarps().set(Warp + ".world", world);
					warps.getWarps().set(Warp + ".x", x);
					warps.getWarps().set(Warp + ".y", y);
					warps.getWarps().set(Warp + ".z", z);
					warps.getWarps().set(Warp + ".yaw", yaw);
					warps.getWarps().set(Warp + ".pitch", pitch);
					warps.saveData();
					warps.reloadData();
					player.sendMessage(ChatColor.DARK_AQUA + "The warp " + ChatColor.YELLOW + Warp + ChatColor.DARK_AQUA + " has been created!");
					return true;
				}else{
					player.sendMessage(ChatColor.RED + "Please specify a warp to create.");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.setwarp " + ChatColor.RED + "to perform this command.");
			}
		}else if(cmd.getName().equalsIgnoreCase("delwarp")){
			WarpFile warps = plugin.getWarpData();
			if(player.hasPermission("notaro.delwarp") || player.hasPermission("notaro.*")){
				if(args.length == 1){
					String Warp = String.valueOf(args[0].toLowerCase());
					if(warps.getWarps().contains(Warp)){
						warps.getWarps().set(Warp, null);
						warps.saveData();
						warps.reloadData();
						player.sendMessage(ChatColor.DARK_AQUA + "The warp " + ChatColor.YELLOW + Warp + ChatColor.DARK_AQUA + " has been deleted!");
						return true;
					}else{
						player.sendMessage(ChatColor.DARK_AQUA + "The warp " + ChatColor.YELLOW + Warp + ChatColor.DARK_AQUA + " does not exist.");
					}
				}else{
					player.sendMessage(ChatColor.RED + "Please specify which warp to delete.");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.delwarp " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
