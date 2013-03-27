package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Position implements CommandExecutor{

	private ChatCommands plugin;
	public Position(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("position")){
			if(player.hasPermission("notaro.position") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: POSITION");
				if(args.length == 0){
					ChatColor aqua = ChatColor.DARK_AQUA;
					ChatColor white = ChatColor.WHITE;
					int x = (int)player.getLocation().getX();
					int y = (int)player.getLocation().getY();
					int z = (int)player.getLocation().getZ();
					String world = player.getWorld().getName();
					double blocks = player.getLocation().distance(player.getWorld().getSpawnLocation());
					player.sendMessage(aqua + "World: " + white + world);
					player.sendMessage(aqua + "X: " + white + x);
					player.sendMessage(aqua + "Y: " + white + y);
					player.sendMessage(aqua + "Z: " + white + z);
					player.sendMessage(aqua + "Distance from spawn: " + white + blocks);
				}
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.position " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
