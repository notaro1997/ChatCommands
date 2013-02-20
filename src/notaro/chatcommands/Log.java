package notaro.chatcommands;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;

public class Log{

	private ChatCommands plugin;
	private Logger log;

	public Log(ChatCommands plugin){
		this.plugin = plugin;
		this.log = Logger.getLogger("Minecraft");
	}

	private String buildString(String msg){
		PluginDescriptionFile pdf = plugin.getDescription();
		return "[" + pdf.getName() + " " + pdf.getVersion() + "]: " + msg;
	}

	public void info(String msg){
		this.log.info(buildString(msg));
	}

	public void warn(String msg){
		this.log.warning(buildString(msg));
	}

	public void severe(String msg){
		this.log.severe(buildString(msg));
	}
}