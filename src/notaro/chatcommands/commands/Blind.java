package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Blind implements CommandExecutor{

	private ChatCommands plugin;
	public Blind(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("blind") && args.length == 1){
			if(sender instanceof Player){
				if(player.hasPermission("notaro.blind") || player.hasPermission("notaro.*")){
					plugin.log.info(player.getName() + ": ChatCommands: BLIND");
					if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
							PotionEffectType effect = (PotionEffectType.BLINDNESS);
							target.addPotionEffect(effect.createEffect(15000, 100));
							player.sendMessage(ChatColor.AQUA + "You have blinded " + target.getDisplayName());
							target.sendMessage(ChatColor.AQUA + "You have been Blinded by: " + ChatColor.RED + "Science");
						}
					}

				} else{

					player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.blind " + ChatColor.RED + "to perform this command.");
				}	
				return true;

			}

			return false;

		} else if(cmd.getName().equalsIgnoreCase("unblind") && args.length == 1){

			if(player.hasPermission("notaro.unblind") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: UNBLIND");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						target.removePotionEffect(PotionEffectType.BLINDNESS);
						player.sendMessage(ChatColor.AQUA + "You have unblinded " + target.getDisplayName());
						target.sendMessage(ChatColor.AQUA + "You have been un-Blinded by: " + ChatColor.RED + player.getDisplayName());
					}
				}

			} else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.unblind " + ChatColor.RED + "to perform this command.");
			}   
		}else{
			player.sendMessage(ChatColor.RED + "Please specify who to blind/unblind.");
		}
		return false;
	}
}

