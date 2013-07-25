package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Spawner implements CommandExecutor{

	private ChatCommands plugin;
	public Spawner(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spawner") && args.length == 1){
			if(player.hasPermission("notaro.spawner") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SPAWNER");
				if(player.getTargetBlock(null, 15).getType().equals(Material.MOB_SPAWNER)){
					CreatureSpawner spawner = (CreatureSpawner) player.getTargetBlock(null, 15).getState();
					try{
						spawner.setSpawnedType(EntityType.valueOf(args[0].toUpperCase()));
						int x = player.getTargetBlock(null, 15).getX();
						int y = player.getTargetBlock(null, 15).getY();
						int z = player.getTargetBlock(null, 15).getZ();
						player.sendMessage(ChatColor.DARK_AQUA + "The spawner at " + ChatColor.YELLOW + x + ", " + y + ", " + z + ChatColor.DARK_AQUA + " will now spawn " + ChatColor.RED + args[0] + ".");
					}catch(Exception error){
						player.sendMessage(ChatColor.RED + "Unknown mob.");
					}
					}else{
						player.sendMessage(ChatColor.RED + "Please point at a spawner.");
					}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.spawner " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type /spawner <mobname> whilst pointing at a spawner");
		}
		return false;
	}
}
