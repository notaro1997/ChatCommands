package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockHere implements CommandExecutor{

	private ChatCommands plugin;
	public BlockHere(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("blockhere") && args.length == 1){
			if(player.hasPermission("notaro.blockhere") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: BLOCKHERE");

				Material material = null;
				try {
					material = Material.getMaterial(Integer.parseInt(args[0]));
				} catch (NumberFormatException e) {
					material = Material.getMaterial(args[0].toUpperCase());
				}
				if (material == null){
					player.sendMessage(ChatColor.RED + "Unknown item.");	

				} else if(args.length == 1){
					if(!player.getWorld().getBlockAt(player.getTargetBlock(null, 500).getLocation()).getType().equals(Material.AIR)){
						player.getWorld().getBlockAt(player.getTargetBlock(null, 500).getLocation()).setType(material);		
					}else{
						player.sendMessage(ChatColor.RED + "Please point at a block.");
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.blockhere " + ChatColor.RED + "to perform this command."); 
			}
		}else{
			player.sendMessage(ChatColor.RED + "Type: /blockhere then a block type.");
		}
		return false;
	}
}
