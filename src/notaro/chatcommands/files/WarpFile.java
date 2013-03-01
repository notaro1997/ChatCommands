package notaro.chatcommands.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import notaro.chatcommands.ChatCommands;

public class WarpFile {

	private ChatCommands plugin;
	public WarpFile(ChatCommands plugin){
		this.plugin = plugin;
	}

	private File WarpFile = null;
	private FileConfiguration Warps = null;


	public void loadData(){
		this.getWarps().options().copyDefaults(true);
		saveData();
	}

	public void reloadData(){
		if(WarpFile == null){
			WarpFile = new File(plugin.getDataFolder(), "Warps.yml");
		}
		Warps = YamlConfiguration.loadConfiguration(WarpFile);
		InputStream ConfigStream = plugin.getResource("WarpFile.yml");
		if(ConfigStream != null){
			YamlConfiguration Config = YamlConfiguration.loadConfiguration(ConfigStream);
			Warps.setDefaults(Config);
		}
	}

	public FileConfiguration getWarps(){
		if(Warps == null){
			reloadData();
		}
		return Warps;
	}

	public void saveData(){
		if (Warps == null || WarpFile == null){
			return;
		}
		try{
			Warps.save(WarpFile);
		}catch (IOException error){
			error.printStackTrace();
		}
	}
}
