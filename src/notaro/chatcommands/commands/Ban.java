package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor{

	private ChatCommands plugin;
	public Ban(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ban")){
			if(sender.hasPermission("notaro.ban") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: BAN");
				if(args.length != 0){
					int i = 1;
					int para = args.length;
					String MSG = "";
					while(i < para){
						MSG = MSG + " " + args[i];
						i++;
					}
					Player target = Bukkit.getPlayer(args[0]);
					plugin.KickedPlayers.add(target.getName());
					target.setBanned(true);
					target.kickPlayer(ChatColor.DARK_RED + "BANNED!" + ChatColor.AQUA + " Reason: " + ChatColor.RED + MSG);
					Bukkit.getServer().broadcastMessage(ChatColor.RED + target.getName() + " has been banned by " + sender.getName());
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.ban " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
