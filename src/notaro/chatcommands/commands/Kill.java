package notaro.chatcommands.commands;
import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor{

	private ChatCommands plugin;
	public Kill(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kill") && args.length == 1){
			if(sender.hasPermission("notaro.kill") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: KILL");
				Player target = Bukkit.getPlayer(args[0]);
				target.setHealth(0);
				target.sendMessage(ChatColor.RED + "Killed.");
				sender.sendMessage(ChatColor.RED + "Killed: " + target.getDisplayName());
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.kill " + ChatColor.RED + "to perform this command.");
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Please specify who to kill.");
		}
		return false;
	}
}
