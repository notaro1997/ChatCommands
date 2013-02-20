package notaro.chatcommands.commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("kill") && args.length == 1){
			if(player.hasPermission("notaro.kill") || player.hasPermission("notaro.*")){
				Player target = Bukkit.getPlayer(args[0]);
				target.setHealth(0);
				target.sendMessage(ChatColor.RED + "Killed.");
				player.sendMessage(ChatColor.RED + "Killed: " + target.getDisplayName());
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.kill " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Please specify who to kill.");
		}
		return false;	
	}
}
