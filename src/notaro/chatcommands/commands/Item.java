package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Item implements CommandExecutor{
	public static ChatCommands plugin;
	public Item(ChatCommands instance){
		plugin = instance;

	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("item")){
			if(sender.hasPermission("notaro.item")){
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "Type: /item ITEM AMOUNT (Amount is optional)");
					return true;
				}
				Material material = null;
				try {
					material = Material.getMaterial(Integer.parseInt(args[0]));
				} catch (NumberFormatException e) {
					material = Material.getMaterial(args[0].toUpperCase());
				}
				if (material == null){
					player.sendMessage(ChatColor.RED + "Unknown item.");
					return true;
				}else{
					if(args.length == 1){
						ItemStack item = new ItemStack(material, 1);
						player.getInventory().addItem(item);
						player.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.YELLOW + "1 " + ChatColor.DARK_PURPLE + material.name().toLowerCase().replace("_", " "));
						return true;
					}else{
						if(args.length == 2){
							Integer value = Integer.valueOf(args[1]);
							ItemStack item = new ItemStack(material, value);
							player.getInventory().addItem(item);
							if(value == 1){
								player.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().toLowerCase().replace("_", " "));
							}else{
								player.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().toLowerCase().replace("_", " ") + "'s");
							}
							return true;
						}else{
							if(args.length == 3){
								Integer value = Integer.valueOf(args[1]);
								short data = Short.parseShort(args[2]);
								ItemStack item = new ItemStack(material, value, data);
								player.getInventory().addItem(item);
								if(value == 1){
									player.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().toLowerCase().replace("_", " "));
								}else{
									player.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().toLowerCase().replace("_", " ") + "'s");
								}
								return true;
							}else{
								return false;
							}
						}
					}
				}
			}
		}
		return false;
	}
}