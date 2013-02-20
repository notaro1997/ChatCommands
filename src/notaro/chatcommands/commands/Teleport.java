package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.TpBlockFile;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor{
	private ChatCommands plugin;
	public Teleport(ChatCommands plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		Player target = Bukkit.getPlayer(args[0]);
		String Target = target.getName();
		TpBlockFile TpBlockFile = plugin.TpBlockPlayers;
		if(cmd.getName().equalsIgnoreCase("tp") && args.length == 1){
			if(player.hasPermission("notaro.tp") || player.hasPermission("notaro.*")){
				if(!TpBlockFile.contains(Target)){
				player.teleport(target);
				player.sendMessage(ChatColor.DARK_AQUA + "You teleported to " + target.getDisplayName() + ChatColor.DARK_AQUA + "!");
				target.sendMessage(ChatColor.DARK_AQUA + player.getDisplayName() +" teleported to you." + "!");
				}else{
					player.sendMessage(ChatColor.RED + "You cannot tp to " + target.getDisplayName() + ChatColor.RED + " at this time.");
					target.sendMessage(player.getDisplayName() + ChatColor.DARK_AQUA + (" tried to tp to you."));
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.tp " + ChatColor.RED + "to perform this command.");
			}
		}else if(cmd.getName().equalsIgnoreCase("summon") && args.length == 1){
			if(player.hasPermission("notaro.summon") || player.hasPermission("notaro.*")){
				target.teleport(player);
				player.sendMessage(ChatColor.DARK_AQUA + "You summoned " + target.getDisplayName() + ChatColor.DARK_AQUA + "!");
				target.sendMessage(ChatColor.DARK_AQUA + player.getDisplayName() +" summoned you." + ChatColor.DARK_AQUA + "!");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.summon " + ChatColor.RED + "to perform this command.");
			}
		}else{
		player.sendMessage(ChatColor.RED + "Please specify who to tp to/summon.");
		}
		return false;	
	}
}