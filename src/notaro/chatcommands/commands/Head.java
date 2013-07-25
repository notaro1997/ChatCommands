package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;

public class Head implements CommandExecutor{

	private ChatCommands plugin;
	public Head(ChatCommands plugin){
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
		if(cmd.getName().equalsIgnoreCase("head")){
			if(player.hasPermission("notaro.head") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: HEAD");
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				PlayerInventory inv = player.getInventory();
				SkullMeta meta = (SkullMeta) item.getItemMeta();
				meta.setOwner(args[0]);
				meta.setDisplayName(ChatColor.RED + args[0] + "'s head");				
				item.setItemMeta(meta);
				inv.addItem(item);
				player.updateInventory();
				player.sendMessage(ChatColor.YELLOW + "You received the head of " + args[0]);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.head " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}