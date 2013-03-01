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

public class MuteFile {

	public static ChatCommands plugin;
	public MuteFile(ChatCommands instance){
		plugin = instance;
	}

	public File MuteFile;
	public ArrayList<String> MutedPlayers;

	public MuteFile(File file){
		this.MuteFile = file;
		this.MutedPlayers = new ArrayList<String>();

		if(!this.MuteFile.exists()){
			try{
				this.MuteFile.createNewFile();
			}catch(IOException IOError){
				IOError.printStackTrace();		
			}
		}
	}
	public void loadData(){
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.MuteFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null){
				if(!this.contains(line)){
					this.MutedPlayers.add(line);
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
			FileWriter stream = new FileWriter(this.MuteFile);
			BufferedWriter output = new BufferedWriter(stream);

			for (String value : this.MutedPlayers){	
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
		return this.MutedPlayers.contains(value);
	}

	public void add(String value){
		if (!this.contains(value)){
			this.MutedPlayers.add(value);
		}
	}

	public void remove(String value){
		this.MutedPlayers.remove(value);
	}

	public ArrayList<String> getValues(){
		return this.MutedPlayers;
	}
}
