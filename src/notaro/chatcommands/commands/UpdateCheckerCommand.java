package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UpdateCheckerCommand implements CommandExecutor{

	private ChatCommands plugin;
	public UpdateCheckerCommand(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("updatechecker") && args.length == 1){
			if(sender.hasPermission("notaro.updatechecker") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: UPDATECHECKER");
				if(args[0].equalsIgnoreCase("true")){	
					plugin.getServerData.remove("UpdateChecker_False");
					plugin.getServerData.saveData();
					plugin.getServerData.add("UpdateChecker_True");
					plugin.getServerData.saveData();
					sender.sendMessage(ChatColor.RED + "ChatCommands update-checker set to: " + ChatColor.YELLOW + "True " + ChatColor.BLUE + "(Recomended)");
				}
				if(args[0].equalsIgnoreCase("false")){
					plugin.getServerData.remove("UpdateChecker_True");
					plugin.getServerData.saveData();
					plugin.getServerData.add("UpdateChecker_False");
					plugin.getServerData.saveData();
					sender.sendMessage(ChatColor.RED + "ChatCommands update-checker set to: " + ChatColor.YELLOW + "False " + ChatColor.BLUE + "(NOT Recomended)");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.updatechecker " + ChatColor.RED + "to perform this command.");
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Please type /updatechecker true or false.");
		}
		return false;	
	}
}