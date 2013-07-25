package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeOp implements CommandExecutor{

	private ChatCommands plugin;
	public FakeOp(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fakeop")){
			if(sender.hasPermission("notaro.fakeop") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: FAKEOP");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					target.sendMessage(ChatColor.YELLOW + "You are now op!");
					sender.sendMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.YELLOW + " most likely thinks they're op now.");
				}
			} else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.fakeop " + ChatColor.RED + "to perform this command."); 	
			}
		}
		return false;
	}
}
