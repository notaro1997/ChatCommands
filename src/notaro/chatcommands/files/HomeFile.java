package notaro.chatcommands.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import notaro.chatcommands.ChatCommands;

public class HomeFile {

	private ChatCommands plugin;
	public HomeFile(ChatCommands plugin){
		this.plugin = plugin;
	}

	private File HomeFile = null;
	private FileConfiguration Homes = null;


	public void loadData(){
		this.getHome().options().copyDefaults(true);
		saveData();
	}

	public void reloadData(){
		if(HomeFile == null){
			HomeFile = new File(plugin.getDataFolder(), "Homes.yml");
		}
		Homes = YamlConfiguration.loadConfiguration(HomeFile);
		InputStream ConfigStream = plugin.getResource("HomeFile.yml");
		if(ConfigStream != null){
			YamlConfiguration Config = YamlConfiguration.loadConfiguration(ConfigStream);
			Homes.setDefaults(Config);
		}
	}

	public FileConfiguration getHome(){
		if(Homes == null){
			reloadData();
		}
		return Homes;
	}

	public void saveData(){
		if (Homes == null || HomeFile == null){
			return;
		}
		try{
			Homes.save(HomeFile);
		}catch (IOException error){
			error.printStackTrace();
		}
	}
}
