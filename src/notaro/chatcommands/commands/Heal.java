package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Heal implements CommandExecutor{

	private ChatCommands plugin;
	public Heal(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("heal") && args.length == 1){
			if(sender.hasPermission("notaro.heal") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: HEAL");
				if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						PotionEffectType effect = (PotionEffectType.HEAL);
						target.addPotionEffect(effect.createEffect(1500000, 100));
						sender.sendMessage(ChatColor.AQUA + "You have healed: " + target.getDisplayName());
						if(!(sender instanceof Player)){
						target.sendMessage(ChatColor.AQUA + "You were healed by: " + sender.getName());
						}else{
							Player player = (Player) sender;
							target.sendMessage(ChatColor.AQUA + "You were healed by: " + player.getDisplayName());
						}
					}
				}    
			} else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.heal " + ChatColor.RED + "to perform this command.");
			}  
		}else{
			sender.sendMessage(ChatColor.RED + "Please specify who to heal.");
		}
		return false;
	}
}
