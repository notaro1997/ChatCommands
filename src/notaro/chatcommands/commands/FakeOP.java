package notaro.chatcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeOP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("fakeop")){
			if(player.hasPermission("notaro.fakeop") || player.hasPermission("notaro.*")){
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					target.sendMessage(ChatColor.YELLOW + "You are now op!");
					player.sendMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.YELLOW + " most likely thinks they're op now.");
				}
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.fakeop " + ChatColor.RED + "to perform this command."); 	
			}
		}
		return false;
	}
}
