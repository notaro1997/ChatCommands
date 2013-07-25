package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor{

	private ChatCommands plugin;
	public God(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("god")){
			if(sender.hasPermission("notaro.god") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: GOD");
				Player target = Bukkit.getPlayer(args[0]);
				PlayerData playerData = plugin.getPlayerData();
				if(playerData.getPlayers().getString(target.getName() + ".God") == "false"){
					playerData.getPlayers().set(target.getName() + ".God", true);
					playerData.saveData();
					sender.sendMessage(ChatColor.YELLOW + target.getName() + " is now in god mode.");
					target.sendMessage(ChatColor.YELLOW + "You are now in god mode.");
				}else{
					playerData.getPlayers().set(target.getName() + ".God", false);
					playerData.saveData();
					sender.sendMessage(ChatColor.YELLOW + target.getName() + " is no longer in god mode.");
					target.sendMessage(ChatColor.YELLOW + "You are no longer in god mode.");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.god " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}