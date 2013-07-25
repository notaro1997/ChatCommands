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
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnEgg implements CommandExecutor{

	private ChatCommands plugin;
	public SpawnEgg(ChatCommands plugin){
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		String playerName = player.getName();
		ItemStack egg = new ItemStack(Material.MONSTER_EGG, 1);
		PlayerInventory inventory = player.getInventory();
		ItemMeta meta = egg.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_RED + "Spawn All Mobs!");
		egg.setItemMeta(meta);
		if (!player.hasPermission("notaro.egg") || !player.hasPermission("notaro.*")){
			player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.egg " + ChatColor.RED + "to perform this command.");
		} else if (plugin.spawnEggPlayers.contains(playerName)){
			plugin.log.info(player.getName() + ": ChatCommands: EGG");
			plugin.spawnEggPlayers.remove(playerName);
			player.sendMessage(ChatColor.DARK_AQUA + "Spawn egg: " + ChatColor.DARK_GREEN + "disabled");
			inventory.removeItem(egg);
		} else{
			plugin.log.info(player.getName() + ": ChatCommands: EGG");
			plugin.spawnEggPlayers.add(playerName);
			player.sendMessage(ChatColor.DARK_AQUA + "Spawn egg: " + ChatColor.DARK_GREEN + "enabled");
			inventory.addItem(egg);
			
		}
		return true;
	}
}
