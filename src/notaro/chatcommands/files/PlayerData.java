package notaro.chatcommands.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import notaro.chatcommands.ChatCommands;

public class PlayerData {

	private ChatCommands plugin;
	public PlayerData(ChatCommands plugin){
		this.plugin = plugin;
	}

	private File KickFile = null;
	private FileConfiguration KickedPlayers = null;


	public void loadData(){
		this.getPlayers().options().copyDefaults(true);
		saveData();
	}

	public void reloadData(){
		if(KickFile == null){
			KickFile = new File(new File(plugin.getDataFolder(), "Logging"), "Players.yml");
		}
		KickedPlayers = YamlConfiguration.loadConfiguration(KickFile);
		InputStream ConfigStream = plugin.getResource("Logging\\Players.yml");
		if(ConfigStream != null){
			YamlConfiguration Config = YamlConfiguration.loadConfiguration(ConfigStream);
			KickedPlayers.setDefaults(Config);
		}
	}

	public FileConfiguration getPlayers(){
		if(KickedPlayers == null){
			reloadData();
		}
		return KickedPlayers;
	}

	public void saveData(){
		if (KickedPlayers == null || KickFile == null){
			return;
		}
		try{
			KickedPlayers.save(KickFile);
		}catch (IOException error){
			error.printStackTrace();
		}
	}
}
