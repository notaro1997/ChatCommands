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
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("exp") && args.length == 2){
			if(player.hasPermission("notaro.exp") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: EXP");
				Player target = Bukkit.getPlayer(args[0]);
				int value = Integer.valueOf(args[1]);
				target.setLevel(value);
				player.sendMessage(ChatColor.YELLOW + "You set " + target.getName() + "'s exp level to " + value);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.exp " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type: /exp PLAYER AMOUNT");
		}
		return false;	
	}
}