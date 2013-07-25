package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;
import notaro.chatcommands.files.BlockFile;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Block implements CommandExecutor{

	private ChatCommands plugin;
	public Block(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		BlockFile blockFile = plugin.BlockedItems;
		if(cmd.getName().equalsIgnoreCase("block") && args.length == 1){
			if(sender.hasPermission("notaro.block") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: BLOCK");
				if(args[0].equalsIgnoreCase("mob") || args[0].equalsIgnoreCase("mobs")){
					blockFile.add("mobs");
					blockFile.saveData();
					sender.sendMessage(ChatColor.YELLOW + "Mobs blocked.");
				}else{
					Material material = null;
					try {
						material = Material.getMaterial(Integer.parseInt(args[0]));
					} catch (NumberFormatException e) {
						material = Material.getMaterial(args[0].toUpperCase());
					}
					if (material == null){
						if(!args[0].equalsIgnoreCase("mob") || !args[0].equalsIgnoreCase("mobs")){
							sender.sendMessage(ChatColor.RED + "Unknown item.");	
						}
					}
					else if(args[0].equalsIgnoreCase(material.toString())){
						blockFile.add(material.toString().toLowerCase());
						blockFile.saveData();
						sender.sendMessage(ChatColor.YELLOW + material.toString().toLowerCase() + " blocked.");
					}
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.block " + ChatColor.RED + "to perform this command.");
			}
		}else if(cmd.getName().equalsIgnoreCase("unblock") && args.length == 1){
			if(sender.hasPermission("notaro.unblock") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: UNBLOCK");
				if(blockFile.contains(args[0])){
					blockFile.remove(args[0]);
					sender.sendMessage(ChatColor.YELLOW + args[0] + " unblocked.");
					blockFile.saveData();
				}else if(args[0].equalsIgnoreCase("mob")){
					blockFile.remove("mobs");
					blockFile.saveData();
					sender.sendMessage(ChatColor.YELLOW + "Mobs unblocked.");
				}else{
					sender.sendMessage(ChatColor.RED + args[0] + " wasn't blocked.");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.unblock " + ChatColor.RED + "to perform this command.");
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Type /block then something to block. Or /unblock ");
		}
		return false;	
	}
}