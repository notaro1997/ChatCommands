package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Invis implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		} 
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("invis")){
			if(player.hasPermission("notaro.invis") || player.hasPermission("notaro.*")){
				PotionEffectType effect = (PotionEffectType.INVISIBILITY);
				player.addPotionEffect(effect.createEffect(999999999, 1));
				player.sendMessage(ChatColor.DARK_AQUA + "You are now invisible.");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.invis " + ChatColor.RED + "to perform this command.");
			}
		} 
		else if(cmd.getName().equalsIgnoreCase("vis") || player.hasPermission("notaro.*")){
			if(player.hasPermission("notaro.vis")){
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
				player.sendMessage(ChatColor.DARK_AQUA + "You are no longer invisible.");
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.vis " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}
