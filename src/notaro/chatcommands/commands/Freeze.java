package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor{

	private ChatCommands plugin;
	public Freeze(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("freeze")){
			if(sender.hasPermission("notaro.freeze") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: FREEZE");
				try{
					Player target = Bukkit.getPlayer(args[0]);
					if(target.getPassenger() != target){
						target.setPassenger(target);
						sender.sendMessage(ChatColor.DARK_AQUA + target.getDisplayName() + ChatColor.DARK_AQUA + " has been frozen.");
						target.sendMessage(ChatColor.AQUA + "You have been frozen!");
					}else{
						target.getPassenger().eject();
						sender.sendMessage(ChatColor.DARK_AQUA + target.getDisplayName() + ChatColor.DARK_AQUA + " is no longer frozen.");
						target.sendMessage(ChatColor.AQUA + "You have been unfrozen!");
					}
				}catch(Exception errors){
					sender.sendMessage(ChatColor.RED + args[0] + " isn't online!");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.freeze " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}