package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Up implements CommandExecutor{

	private ChatCommands plugin;
	public Up(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("up") && args.length == 1){
			if(player.hasPermission("notaro.up") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: UP");
				Location loc = player.getLocation();
				int up = Integer.parseInt(args[0]);
				Block blockBelowFeet = player.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() + up - 1, loc.getBlockZ());
				Location newLoc = loc.add(0, up, 0);
				blockBelowFeet.setType(Material.GLASS);
				player.teleport(newLoc);
				player.sendMessage(ChatColor.AQUA + "You were teleported " + up + " block(s) up.");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.up " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Please specify how many blocks to teleport up.");
		}
		return false;	
	}
}