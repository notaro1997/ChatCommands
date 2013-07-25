package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Exp implements CommandExecutor{

	private ChatCommands plugin;
	public Exp(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("exp") && args.length == 2){
			if(sender.hasPermission("notaro.exp") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: EXP");
				Player target = Bukkit.getPlayer(args[0]);
				int value = Integer.valueOf(args[1]);
				target.setLevel(value);
				sender.sendMessage(ChatColor.YELLOW + "You set " + target.getName() + "'s exp level to " + value);
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.exp " + ChatColor.RED + "to perform this command.");
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Type: /exp PLAYER AMOUNT");
		}
		return false;	
	}
}