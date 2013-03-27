package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.UpdateCheckerFile;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpdateCheckerCommand implements CommandExecutor{

	private ChatCommands plugin;
	public UpdateCheckerCommand(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		UpdateCheckerFile UpdateCheckerFile = plugin.UpdateTrueOrFalse;
		if(cmd.getName().equalsIgnoreCase("updatechecker") && args.length == 1){
			if(player.hasPermission("notaro.updatechecker") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: UPDATECHECKER");
				String update = String.valueOf(args[0]);
				if(update.equalsIgnoreCase("true")){
					UpdateCheckerFile.remove("False");
					UpdateCheckerFile.saveData();
					UpdateCheckerFile.add("True");
					UpdateCheckerFile.saveData();
				}
				if(update.equalsIgnoreCase("false")){
					UpdateCheckerFile.remove("True");
					UpdateCheckerFile.saveData();
					UpdateCheckerFile.add("False");
					UpdateCheckerFile.saveData();
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.updatechecker " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Please type /updatechecker true or false.");
		}
		return false;	
	}
}