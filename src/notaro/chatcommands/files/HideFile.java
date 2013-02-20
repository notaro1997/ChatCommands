package notaro.chatcommands.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import notaro.chatcommands.ChatCommands;

public class HideFile {

	public static ChatCommands plugin;
	public HideFile(ChatCommands instance){
		plugin = instance;
	}

	public File HideFile;
	public ArrayList<String> HiddenPlayers;

	public HideFile(File file){
		this.HideFile = file;
		this.HiddenPlayers = new ArrayList<String>();

		if(!this.HideFile.exists()){
			try{
				this.HideFile.createNewFile();
			}catch(IOException IOError){
				IOError.printStackTrace();		
			}
		}
	}
	public void loadData(){

		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.HideFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null){
				if(!this.contains(line)){
					this.HiddenPlayers.add(line);
				}
			}
			reader.close();
			input.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void saveData(){
		try {
			FileWriter stream = new FileWriter(this.HideFile);
			BufferedWriter output = new BufferedWriter(stream);

			for (String value : this.HiddenPlayers){	
				output.write(value);
				output.newLine();
			}	
			output.close();
			stream.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

	public boolean contains(String value){
		return this.HiddenPlayers.contains(value);
	}

	public void add(String value){
		if (!this.contains(value)){
			this.HiddenPlayers.add(value);
		}
	}

	public void remove(String value){
		this.HiddenPlayers.remove(value);
	}

	public ArrayList<String> getValues(){
		return this.HiddenPlayers;
	}
}
