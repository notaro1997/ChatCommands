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
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		PlayerData PlayerData = plugin.getPlayerData();
		if(cmd.getName().equalsIgnoreCase("kick")){
			if(player.hasPermission("notaro.kick") || player.hasPermission("notaro.*")){
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
					int I = PlayerData.getPlayers().getInt(targetName + ".Kicked");
					PlayerData.getPlayers().set(targetName + ".Kicked", I + 1);
					PlayerData.saveData();
					plugin.KickedPlayers.add(target.getName());
					target.kickPlayer(ChatColor.DARK_RED + "KICKED!" + ChatColor.AQUA + " Reason: " + ChatColor.RED + MSG);
					Bukkit.getServer().broadcastMessage(ChatColor.BLUE + target.getName() + " has been kicked by " + player.getName());
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.kick " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}
