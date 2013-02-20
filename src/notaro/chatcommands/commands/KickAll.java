package notaro.chatcommands.commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickAll implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("kickall")){
			if(player.hasPermission("notaro.kickall") || player.hasPermission("notaro.*")){
				int i = 0;
				for(Player online : Bukkit.getOnlinePlayers()){
					if (!online.equals(player)){
						online.kickPlayer(ChatColor.RED + "Emergency kick. All players have been kicked.");
						i++;
					}
				}
				player.sendMessage(ChatColor.RED + "Kicked: " + ChatColor.AQUA + i);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.kickall " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}
