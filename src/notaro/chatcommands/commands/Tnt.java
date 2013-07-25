package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Tnt implements CommandExecutor{

	private ChatCommands plugin;
	public Tnt(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tnt")){
			if(player.hasPermission("notaro.tnt") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: TNT");
				player.getWorld().spawnEntity(player.getTargetBlock(null, 600).getLocation(), EntityType.PRIMED_TNT);
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.tnt " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
