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
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		} 
		Player player = (Player) sender;
		MuteFile MuteFile = plugin.MutedPlayers;
		if(cmd.getName().equalsIgnoreCase("mute") && args.length == 1){
			if(player.hasPermission("notaro.mute") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: MUTE");
				Player target = Bukkit.getPlayer(args[0]);
				String name = target.getName();
				MuteFile.add(name);
				MuteFile.saveData();
				player.sendMessage(ChatColor.DARK_GRAY + target.getName() + ChatColor.GRAY + " is now muted.");
				target.sendMessage(ChatColor.RED + "You are now muted! Anything you say will not be seen.");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.mute " + ChatColor.RED + "to perform this command.");
			}
		} else if(cmd.getName().equalsIgnoreCase("unmute")){
			if(player.hasPermission("notaro.unmute")){
				plugin.log.info(player.getName() + ": ChatCommands: UNMUTE");
				Player target = Bukkit.getPlayer(args[0]);
				String name = target.getName();
				MuteFile.remove(name);
				MuteFile.saveData();
				player.sendMessage(ChatColor.DARK_GRAY + target.getName() + ChatColor.GRAY + " is no longer muted.");
				target.sendMessage(ChatColor.RED + "You are no longer muted.");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.unmute " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}