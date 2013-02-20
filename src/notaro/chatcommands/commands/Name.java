package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Name implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("name")){
			if(player.hasPermission("notaro.name") || player.hasPermission("notaro.*")){
				if(args.length >= 2){
					ChatColor color = ChatColor.getByChar(args[0]);
					String name = String.valueOf(args[1]);
					player.setDisplayName(color + name.toString() + ChatColor.WHITE);
					player.setPlayerListName(color + name.toString());
					player.sendMessage(ChatColor.GRAY + "Your name is now: " + color + name.toString());
				}else{
					player.sendMessage(ChatColor.RED + "Please specify the name you want.");
				}
			} else{	 
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.name " + ChatColor.RED + "to perform this command."); 
			}
		}
		return false;
	}
}
