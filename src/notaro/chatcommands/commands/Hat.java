package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Hat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("hat")){
			if(player.hasPermission("notaro.hat") || player.hasPermission("notaro.*")){
				PlayerInventory inv = player.getInventory();
				ItemStack hat = inv.getHelmet();
				if(inv == null || player.getItemInHand().getType() == Material.AIR){
					player.sendMessage(ChatColor.RED + "No items to make your hat.");
				}
				if(player.getItemInHand().getType() != Material.AIR){
					ItemStack item = player.getItemInHand().clone();
					if(item.getType().getMaxDurability() == 0){
						player.sendMessage(ChatColor.YELLOW + "I like your " + ChatColor.GOLD + player.getItemInHand().getType() + ChatColor.YELLOW + " hat.");
						item.setAmount(1);
						inv.remove(item);
						inv.setHelmet(item);
						inv.setItemInHand(hat);		
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.hat " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}