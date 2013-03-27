package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Give implements CommandExecutor{

	private ChatCommands plugin;
	public Give(ChatCommands plugin){
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("give") && args.length > 1){
			Material material = null;
			try{
				material = Material.getMaterial(Integer.parseInt(args[1]));
			}catch(NumberFormatException error){
				material = Material.getMaterial(args[1].toUpperCase());
			}
			if(material != null){
				if(player.hasPermission("notaro.give")){
					plugin.log.info(player.getName() + ": ChatCommands: GIVE");
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						if(args.length == 2){
							ItemStack item = new ItemStack(material, 1);
							target.getInventory().addItem(item);
							target.updateInventory();
							target.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.YELLOW + " 1 " + ChatColor.DARK_PURPLE + material.name().replace("_", " ").toLowerCase() + ChatColor.DARK_AQUA + " from " + player.getDisplayName());
							player.sendMessage(ChatColor.DARK_AQUA + "You gave " + target.getDisplayName() + ChatColor.YELLOW + " 1 " + ChatColor.DARK_PURPLE + material.name().replace("_", " ").toLowerCase());
							return true;
						}else if(args.length == 3){
							int value = Integer.parseInt(args[2]);
							ItemStack item = new ItemStack(material, value);
							target.getInventory().addItem(item);
							target.updateInventory();
							target.sendMessage(ChatColor.AQUA + "You received " + ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().replace("_", " ") + ChatColor.DARK_AQUA + " from " + player.getDisplayName());
							player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + " " +  ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().replace("_", " ").toLowerCase() + "'s");
							return true;
						}else if(args.length == 4){
							int value = Integer.parseInt(args[2]);
							short data = Short.parseShort(args[3]);
							ItemStack item = new ItemStack(material, value, data);
							target.getInventory().addItem(item);
							target.updateInventory();
							target.sendMessage(ChatColor.AQUA + "You received " + ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().replace("_", " ") + ChatColor.DARK_AQUA + " from " + player.getDisplayName());
							player.sendMessage(ChatColor.AQUA + "You gave " + target.getDisplayName() + " " +  ChatColor.YELLOW + value + " " + ChatColor.DARK_PURPLE + material.name().replace("_", " ").toLowerCase() + "'s");
							return true;
						}
					}
				}
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type /give PLAYER AMOUNT (DATA)");
		}
		return false;
	}
}