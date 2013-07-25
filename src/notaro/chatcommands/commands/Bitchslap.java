package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bitchslap implements CommandExecutor{

	private ChatCommands plugin;
	public Bitchslap(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("bitchslap")){
			if(sender.hasPermission("notaro.bitchslap") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: BITCHSLAP");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(!(sender instanceof Player)){
						Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.YELLOW + " received a " + ChatColor.RED + "bitchslap " + ChatColor.YELLOW + "from " + ChatColor.YELLOW + "GOD");
					}else{
						Player player = (Player) sender;
						Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.YELLOW + " received a " + ChatColor.RED + "bitchslap " + ChatColor.YELLOW + "from " + ChatColor.YELLOW + player.getDisplayName());
					}
				}else{
					Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "You just got a " + ChatColor.RED + "bitchslap " + ChatColor.YELLOW + "from " + ChatColor.YELLOW + sender.getName());
				}
			} else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.bitchslap " + ChatColor.RED + "to perform this command.");   
			}
		}
		return false;
	}
}