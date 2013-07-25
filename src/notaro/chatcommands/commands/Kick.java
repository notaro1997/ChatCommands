package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {

	private ChatCommands plugin;
	public Kick(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		PlayerData playerData = plugin.getPlayerData();
		if(cmd.getName().equalsIgnoreCase("kick")){
			if(sender.hasPermission("notaro.kick") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: KICK");
				Player target = Bukkit.getPlayer(args[0]);
				String targetName = target.getName();
				if(args.length != 0){
					int i = 1;
					int para = args.length; 
					String MSG = "";
					while(i < para){
						MSG = MSG + " " + args[i];
						i++;
					}
					int k = playerData.getPlayers().getInt(targetName + ".Kicked");
					playerData.getPlayers().set(targetName + ".Kicked", k + 1);
					playerData.saveData();
					plugin.KickedPlayers.add(target.getName());
					target.kickPlayer(ChatColor.DARK_RED + "KICKED!" + ChatColor.AQUA + " Reason: " + ChatColor.RED + MSG);
					Bukkit.getServer().broadcastMessage(ChatColor.BLUE + target.getName() + " has been kicked by " + sender.getName());
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.kick " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
