package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplodingArrowsExecutor implements CommandExecutor{
	private ChatCommands plugin;
	public ExplodingArrowsExecutor(ChatCommands plugin){
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		String playerName = player.getName();
		if (! player.hasPermission("notaro.ea") || player.hasPermission("notaro.*")){
			player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.ea " + ChatColor.RED + "to perform this command.");
		} else if (plugin.enabledPlayers.contains(playerName)){
			plugin.enabledPlayers.remove(playerName);
			player.sendMessage(ChatColor.DARK_AQUA + "Exploding arrows: " + ChatColor.DARK_GREEN + "disabled");
		} else{
			plugin.enabledPlayers.add(playerName);
			player.sendMessage(ChatColor.DARK_AQUA + "Exploding arrows: " + ChatColor.DARK_GREEN + "enabled");
		}

		return true;
	}

}
