package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.MuteFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mute implements CommandExecutor{
	
	private ChatCommands plugin;
	public Mute(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		MuteFile MuteFile = plugin.MutedPlayers;
		if(cmd.getName().equalsIgnoreCase("mute") && args.length == 1){
			if(sender.hasPermission("notaro.mute") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: MUTE");
				Player target = Bukkit.getPlayer(args[0]);
				String name = target.getName();
				MuteFile.add(name);
				MuteFile.saveData();
				sender.sendMessage(ChatColor.DARK_GRAY + target.getName() + ChatColor.GRAY + " is now muted.");
				target.sendMessage(ChatColor.RED + "You are now muted! Anything you say will not be seen.");
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.mute " + ChatColor.RED + "to perform this command.");
			}
		} else if(cmd.getName().equalsIgnoreCase("unmute")){
			if(sender.hasPermission("notaro.unmute")){
				plugin.log.info(sender.getName() + ": ChatCommands: UNMUTE");
				Player target = Bukkit.getPlayer(args[0]);
				String name = target.getName();
				MuteFile.remove(name);
				MuteFile.saveData();
				sender.sendMessage(ChatColor.DARK_GRAY + target.getName() + ChatColor.GRAY + " is no longer muted.");
				target.sendMessage(ChatColor.RED + "You are no longer muted.");
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.unmute " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}