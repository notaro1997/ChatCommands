package notaro.chatcommands.commands;
import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickAll implements CommandExecutor{

	private ChatCommands plugin;
	public KickAll(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kickall")){
			if(sender.hasPermission("notaro.kickall") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: KICKALL");
				int i = 0;
				for(Player online : Bukkit.getOnlinePlayers()){
					if (!online.equals(sender)){
						plugin.KickedPlayers.add(online.getName());
						online.kickPlayer(ChatColor.RED + "Emergency kick. All players have been kicked.");
						i++;
					}
				}
				sender.sendMessage(ChatColor.RED + "Kicked: " + ChatColor.AQUA + i);
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.kickall " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}
