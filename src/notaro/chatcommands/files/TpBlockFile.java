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

public class TpBlockFile {

	public static ChatCommands plugin;
	public TpBlockFile(ChatCommands instance){
		plugin = instance;
	}

	public File TpBlockFile;
	public ArrayList<String> TpBlockPlayers;

	public TpBlockFile(File file){
		this.TpBlockFile = file;
		this.TpBlockPlayers = new ArrayList<String>();

		if(!this.TpBlockFile.exists()){
			try{
				this.TpBlockFile.createNewFile();
			}catch(IOException IOError){
				IOError.printStackTrace();		
			}
		}
	}
	public void loadData(){

		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.TpBlockFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null){
				if(!this.contains(line)){
					this.TpBlockPlayers.add(line);
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
			FileWriter stream = new FileWriter(this.TpBlockFile);
			BufferedWriter output = new BufferedWriter(stream);

			for (String value : this.TpBlockPlayers){	
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
		return this.TpBlockPlayers.contains(value);
	}

	public void add(String value){
		if (!this.contains(value)){
			this.TpBlockPlayers.add(value);
		}
	}

	public void remove(String value){
		this.TpBlockPlayers.remove(value);
	}

	public ArrayList<String> getValues(){
		return this.TpBlockPlayers;
	}
}
