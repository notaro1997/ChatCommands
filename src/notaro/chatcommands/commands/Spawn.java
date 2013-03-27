package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor{

	private ChatCommands plugin;
	public Spawn(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		String world = player.getWorld().getName();
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (player.hasPermission("notaro.setspawn") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SETSPAWN");
				player.sendMessage(ChatColor.DARK_AQUA + "You have succesfully set a new spawn point for world: " + ChatColor.RED + world);
				Location spawn = player.getLocation();
				int x = spawn.getBlockX();
				int y = spawn.getBlockY();
				int z = spawn.getBlockZ();
				@SuppressWarnings("unused")
				float yaw = spawn.getYaw();
				@SuppressWarnings("unused")
				float pitch = spawn.getPitch();
				player.getWorld().setSpawnLocation(x, y, z);
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.setspawn " + ChatColor.RED + "to perform this command.");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (player.hasPermission("notaro.spawn") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SPAWN");
				player.sendMessage(ChatColor.YELLOW + "You succesfully teleported to spawn in world: " + ChatColor.RED + world);
				Location spawn = player.getWorld().getSpawnLocation();
				spawn.setX(spawn.getBlockX() + 0.5);
				spawn.setY(spawn.getBlockY());
				spawn.setZ(spawn.getBlockZ() + 0.5);
				spawn.setYaw(spawn.getYaw());
				spawn.setPitch(spawn.getPitch());
				player.teleport(spawn);	
			} else{	
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.spawn " + ChatColor.RED + "to perform this command.");	
			}
		}
		return false;
	}
}