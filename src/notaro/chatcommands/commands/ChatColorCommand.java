package notaro.chatcommands.commands;

import notaro.chatcommands.ChatCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColorCommand implements Listener, CommandExecutor{

	private ChatColor color = ChatColor.WHITE;
	private ChatCommands plugin;
	public ChatColorCommand(ChatCommands plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("chatcolor") && args.length == 1){
			if(sender.hasPermission("notaro.chatcolor") || sender.hasPermission("notaro.*")){
				plugin.log.info(sender.getName() + ": ChatCommands: CHATCOLOR");
				if(args[0].equals("aqua")){
					setColor(ChatColor.AQUA);
				}
				if(args[0].equalsIgnoreCase("black")){
					setColor(ChatColor.BLACK);
				}
				if(args[0].equalsIgnoreCase("blue")){
					setColor(ChatColor.BLUE);
				}
				if(args[0].equalsIgnoreCase("bold")){
					setColor(ChatColor.BOLD);
				}
				if(args[0].equalsIgnoreCase("dark_aqua")){
					setColor(ChatColor.DARK_AQUA);
				}
				if(args[0].equalsIgnoreCase("dark_blue")){
					setColor(ChatColor.DARK_BLUE);
				}
				if(args[0].equalsIgnoreCase("dark_gray") || args[0].equalsIgnoreCase("dark_grey")){
					setColor(ChatColor.DARK_GRAY);
				}
				if(args[0].equalsIgnoreCase("dark_green")){
					setColor(ChatColor.DARK_GREEN);
				}
				if(args[0].equalsIgnoreCase("dark_purple")){
					setColor(ChatColor.DARK_PURPLE);
				}
				if(args[0].equalsIgnoreCase("dark_red")){
					setColor(ChatColor.DARK_RED);
				}
				if(args[0].equalsIgnoreCase("gold")){
					setColor(ChatColor.GOLD);
				}
				if(args[0].equalsIgnoreCase("gray") || args[0].equalsIgnoreCase("grey")){
					setColor(ChatColor.GRAY);
				}
				if(args[0].equalsIgnoreCase("green")){
					setColor(ChatColor.GREEN);
				}
				if(args[0].equalsIgnoreCase("italic")){
					setColor(ChatColor.ITALIC);
				}
				if(args[0].equalsIgnoreCase("light_purple") || args[0].equalsIgnoreCase("pink")){
					setColor(ChatColor.LIGHT_PURPLE);
				}
				if(args[0].equalsIgnoreCase("magic")){
					setColor(ChatColor.MAGIC);
				}
				if(args[0].equalsIgnoreCase("red")){
					setColor(ChatColor.RED);
				}
				if(args[0].equalsIgnoreCase("strikethrough")){
					setColor(ChatColor.STRIKETHROUGH);
				}
				if(args[0].equalsIgnoreCase("underline")){
					setColor(ChatColor.UNDERLINE);
				}
				if(args[0].equalsIgnoreCase("white")){
					setColor(ChatColor.WHITE);
				}
				if(args[0].equalsIgnoreCase("yellow")){
					setColor(ChatColor.YELLOW);
				}
				sender.sendMessage(getColor() + "Chat color set to " + args[0]);
				if(args[0].equalsIgnoreCase("test")){
					sender.sendMessage(getColor() + "You chose this color for the chat.");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You need the permission: " + ChatColor.DARK_GREEN + "notaro.chatcolor " + ChatColor.RED + "to perform this command.");
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Type /chatcolor then a color");
		}

		return false;	
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		event.setMessage(getColor() + event.getMessage());
	}

	public ChatColor getColor() {
		return color;
	}

	public void setColor(ChatColor color) {
		this.color = color;

	}

}
