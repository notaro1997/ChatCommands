package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.TpBlockFile;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpBlock implements CommandExecutor{
	private ChatCommands plugin;
	public TpBlock(ChatCommands plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		} 
		Player player = (Player) sender;
		String name = player.getName();
		TpBlockFile TpBlockFile = plugin.TpBlockPlayers;
		if(cmd.getName().equalsIgnoreCase("tpblock") && args.length == 1){
			if(player.hasPermission("notaro.tpblock") || player.hasPermission("notaro.*")){
				String tpblock = String.valueOf(args[0]);
				if(tpblock.equalsIgnoreCase("on")){
					TpBlockFile.add(name);
					TpBlockFile.saveData();
					player.sendMessage(ChatColor.DARK_AQUA + "TpBlock enabled for " + player.getDisplayName());
				}else if(tpblock.equalsIgnoreCase("off")){
					TpBlockFile.remove(name);
					TpBlockFile.saveData();
					player.sendMessage(ChatColor.DARK_AQUA + "TpBlock disabled for " + player.getDisplayName());
				}else if(tpblock.equalsIgnoreCase("status")){
					if(TpBlockFile.contains(name)){
						player.sendMessage(ChatColor.DARK_AQUA + "Your TpBlock status is set to: " + ChatColor.RED + "ON");
					}else{
						player.sendMessage(ChatColor.DARK_AQUA + "Your TpBlock status is set to: " + ChatColor.RED + "OFF");
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.tpblock " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type: /tpblock on, off, or status.");
		}
		return false;
	}
}