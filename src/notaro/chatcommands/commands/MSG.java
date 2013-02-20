package notaro.chatcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSG implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("m")){
			if(player.hasPermission("notaro.m") || player.hasPermission("notaro.*")){
				if(sender instanceof Player){
					if(args.length >= 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
							int i = 1; int para = args.length;
							String msg = "";
							while(i < para){
								msg = msg + " " + args[i];
								i++;
							}
							player.sendMessage(ChatColor.GREEN + "to: " + target.getDisplayName() + ChatColor.GREEN + ":" + msg);
							target.sendMessage(ChatColor.GREEN + "from: " + player.getDisplayName() + ChatColor.GREEN + ":" + msg);
						}
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.m " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;
	}
}