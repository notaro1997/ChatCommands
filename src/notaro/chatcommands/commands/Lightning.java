package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lightning implements CommandExecutor{

	private ChatCommands plugin;
	public Lightning(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("lightning")){
			if(player.hasPermission("notaro.lightning") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: LIGHTNING");
				if(args.length == 0){
					player.getWorld().strikeLightning(player.getTargetBlock(null, 1000).getLocation());
				}else if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					target.getWorld().strikeLightning(target.getLocation());
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.lightning " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}