package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class LLL implements CommandExecutor{

	private ChatCommands plugin;
	public LLL(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("lll") && args.length == 1){
			if(sender instanceof Player){
				if(player.hasPermission("notaro.lll") || player.hasPermission("notaro.*")){
					plugin.log.info(player.getName() + ": ChatCommands: LLL");
					if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
							PotionEffectType effect = (PotionEffectType.CONFUSION);
							target.addPotionEffect(effect.createEffect(15000, 100));
							player.sendMessage(ChatColor.AQUA + "You have gotten " + target.getDisplayName() + ChatColor.AQUA + " very high.");
							target.sendMessage(ChatColor.AQUA + "You are as high as Larry!");
						}
					}
				} else{
					player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.lll " + ChatColor.RED + "to perform this command."); 
				}
				return true;	    		    

			}	

			return false;

		} else if(cmd.getName().equalsIgnoreCase("sober") && args.length == 1){
			if(player.hasPermission("notaro.sober") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SOBER");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						target.removePotionEffect(PotionEffectType.CONFUSION);
						player.sendMessage(ChatColor.AQUA + "You have removed " + target.getDisplayName() + ChatColor.AQUA +  "'s high.");
						target.sendMessage(ChatColor.AQUA + "You are no longer livin' like Larry!");
					}
				}    
			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.sober " + ChatColor.RED + "to perform this command.");
			}  
		}else{
			player.sendMessage(ChatColor.RED + "Please specify who to make high/sober.");
		}
		return false;
	}
}
