package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Superpick implements CommandExecutor{

	private ChatCommands plugin;
	public Superpick(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("superpick")){
			if(player.hasPermission("notaro.superpick") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SUPERPICK");
				player.sendMessage(ChatColor.GOLD + "You have now been given a " + ChatColor.AQUA + "superpick");
				PlayerInventory inventory = player.getInventory();
				ItemStack superpick= new ItemStack(Material.DIAMOND_PICKAXE, 1);
				superpick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
				superpick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
				superpick.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
				superpick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
				superpick.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
				superpick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				superpick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
				superpick.addUnsafeEnchantment(Enchantment.WATER_WORKER, 10);
				superpick.addUnsafeEnchantment(Enchantment.OXYGEN, 10);
				superpick.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);
				superpick.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
				superpick.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
				superpick.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
				superpick.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
				superpick.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
				superpick.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
				superpick.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 10);
				superpick.getItemMeta().setDisplayName("Boomstick");
				ItemMeta meta = superpick.getItemMeta();
				meta.setDisplayName(ChatColor.AQUA + "Superpick");
				superpick.setItemMeta(meta);
				inventory.addItem(superpick);
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.superpick " + ChatColor.RED + "to perform this command.");
			}
		}
		return true;
	}
}
