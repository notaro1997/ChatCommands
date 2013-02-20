package notaro.chatcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("heal") && args.length == 1){
			if(player.hasPermission("notaro.heal") || player.hasPermission("notaro.*")){
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						PotionEffectType effect = (PotionEffectType.HEAL);
						target.addPotionEffect(effect.createEffect(1500000, 100));
						player.sendMessage(ChatColor.AQUA + "You have healed: " + target.getDisplayName());
						target.sendMessage(ChatColor.AQUA + "You were healed by: " + player.getDisplayName());
					}
				}    
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.heal " + ChatColor.RED + "to perform this command.");
			}  
		}else{
			player.sendMessage(ChatColor.RED + "Please specify who to heal.");
		}
		return false;
	}
}
