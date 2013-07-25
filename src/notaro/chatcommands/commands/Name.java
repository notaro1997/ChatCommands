package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Name implements CommandExecutor{

	private ChatCommands plugin;
	public Name(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("name")){
			if(player.hasPermission("notaro.name") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: NAME");
				if(args.length == 2){
					ChatColor color = ChatColor.getByChar(args[0]);
					player.setDisplayName(color + args[1].toString() + ChatColor.WHITE);
					player.setPlayerListName(color + args[1].toString());
					player.sendMessage(ChatColor.GRAY + "Your name is now: " + color + args[1].toString());
				}else{
					player.sendMessage(ChatColor.RED + "Correct usage: /name colorcode name");
				}
			} else{	 
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.name " + ChatColor.RED + "to perform this command."); 
			}
		}
		return false;
	}
}
