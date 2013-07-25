package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ride implements CommandExecutor{

	private ChatCommands plugin;
	public Ride(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ride")){
			if(player.hasPermission("notaro.ride") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: RIDE");
				try{
					Player target = Bukkit.getPlayer(args[0]);
					if(target.getPassenger() != player){
						target.setPassenger(player);
						sender.sendMessage(ChatColor.YELLOW + "You are now riding " + target.getName());
						target.sendMessage(ChatColor.YELLOW + player.getName() + " is now riding you!");
					}else{
						target.getPassenger().eject();
						sender.sendMessage(ChatColor.YELLOW + "You are no longer riding " + args[0]);
						target.sendMessage(ChatColor.YELLOW + player.getName() + " is no longer riding you.");
					}
				}catch(Exception errors){
					sender.sendMessage(ChatColor.RED + args[0] + " isn't online!");
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.ride " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
