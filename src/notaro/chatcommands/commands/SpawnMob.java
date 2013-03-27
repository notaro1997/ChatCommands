package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnMob implements CommandExecutor{

	private ChatCommands plugin;
	public SpawnMob(ChatCommands plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("sm")){
			if(player.hasPermission("notaro.sm") || player.hasPermission("notaro.*")){
				plugin.log.info(player.getName() + ": ChatCommands: SM");

				/*
				 * code by Ein Andersson
				 */

				int amount = 1;
				EntityType mobtyp;

				try {
					amount = Integer.parseInt(args[1]);
				} catch (Exception e) {
					amount = 1;
				}

				try {
					String mobname = args[0];
					mobtyp = EntityType.fromName(mobname);
				} catch (Exception e) {
					player.sendMessage(ChatColor.RED + "Sorry that mob doesn't exist.");
					return true;
				}

				if (mobtyp != null) {
					for (int i = 0; i < amount; i++) {

						if (mobtyp.isSpawnable() && mobtyp.isAlive()) {
							player.getWorld().spawnEntity(player.getLocation(), mobtyp);
						}
					} 
					player.sendMessage(ChatColor.DARK_AQUA + "You spawned " + ChatColor.YELLOW + amount + ChatColor.RED + " " + mobtyp.getName());
				}
				else {
					StringBuilder buf = new StringBuilder();
					String delim = "";
					for (EntityType mob : EntityType.values()) {
						if (mob.isSpawnable() && mob.isAlive()) {
							buf.append(delim);
							buf.append(mob.getName());
							delim = ", ";
						}
					}
					player.sendMessage(ChatColor.YELLOW + "Valid names are: ");
					player.sendMessage(ChatColor.GREEN + buf.toString());
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.sm " + ChatColor.RED + "to perform this command.");
			}
		}
		return false;	
	}
}