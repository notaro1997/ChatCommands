package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Mob implements CommandExecutor{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String aliases, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if((cmd.getName().equalsIgnoreCase("sm")) && (args.length == 1)){
			if(player.hasPermission("notaro.sm") || player.hasPermission("notaro.*")){
				String mob = String.valueOf(args[0]);
				if(mob.equalsIgnoreCase("cow")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("COW"));
				}else if(mob.equalsIgnoreCase("chicken")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("CHICKEN"));
					return true;
				}else if(mob.equalsIgnoreCase("wolf")){					
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("WOLF"));
					return true;
				}else if(mob.equalsIgnoreCase("sheep")){				
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SHEEP"));
					return true;
				}else if(mob.equalsIgnoreCase("pig")){	
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("PIG"));
					return true;
				}else if(mob.equalsIgnoreCase("snowman")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SNOWMAN"));
					return true;
				}else if(mob.equalsIgnoreCase("squid")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SQUID"));
					return true;
				}else if(mob.equalsIgnoreCase("creeper")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("CREEPER"));
					return true;
				}else if(mob.equalsIgnoreCase("spider")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SPIDER"));
					return true;
				}else if(mob.equalsIgnoreCase("cavespider")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("CAVE_SPIDER"));
					return true;
				}else if(mob.equalsIgnoreCase("ghast")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("GHAST"));
					return true;
				}else if(mob.equalsIgnoreCase("enderman")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("ENDERMAN"));
					return true;
				}else if(mob.equalsIgnoreCase("enderdragon")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("ENDER_DRAGON"));
					return true;
				}else if(mob.equalsIgnoreCase("blaze")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("BLAZE"));
					return true;
				}else if(mob.equalsIgnoreCase("magmacube")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("MAGMA_CUBE"));
					return true;
				}else if(mob.equalsIgnoreCase("mooshroom")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("MUSHROOM_COW"));
					return true;
				}else if(mob.equalsIgnoreCase("pigzombie")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("PIG_ZOMBIE"));
					return true;
				}else if(mob.equalsIgnoreCase("silverfish")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SILVERFISH"));
					return true;
				}else if(mob.equalsIgnoreCase("skeleton")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SKELETON"));
					return true;
				}else if(mob.equalsIgnoreCase("slime")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("SLIME"));
				}else if(mob.equalsIgnoreCase("zombie")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("ZOMBIE"));
					return true;
				}else if(mob.equalsIgnoreCase("crystal")){
					player.getWorld().spawnEntity(player.getTargetBlock(null, 600).getLocation(), EntityType.ENDER_CRYSTAL);
					return true;
				}else if(mob.equalsIgnoreCase("giant")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("GIANT"));
					return true;
				}else if(mob.equalsIgnoreCase("bat")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("BAT"));
					return true;
				}else if(mob.equalsIgnoreCase("witch")){	
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("WITCH"));
					return true;
				}else if(mob.equalsIgnoreCase("wither")){	
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("WITHER"));
					return true;
				}else if(mob.equalsIgnoreCase("ocelot")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("OCELOT"));
					return true;
				}else if(mob.equalsIgnoreCase("golem")){
					player.getWorld().spawnCreature(player.getTargetBlock(null, 600).getLocation(), EntityType.fromName("IRON_GOLEM"));
					return true;
				}else{
					player.sendMessage(ChatColor.DARK_AQUA + "What mob is that?");
					return true;
				}
			}else{
				player.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.sm " + ChatColor.RED + "to perform this command.");
			}
		}else{
			player.sendMessage(ChatColor.DARK_AQUA + "Correct syntax: /sm mobtype ");
		}
		return false;
	}
}