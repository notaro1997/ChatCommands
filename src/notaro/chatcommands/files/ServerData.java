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

public class ServerData {

	public static ChatCommands plugin;
	public ServerData(ChatCommands instance){
		plugin = instance;
	}

	public File ServerDataFile;
	public ArrayList<String> serverData;

	public ServerData(File file){
		this.ServerDataFile = file;
		this.serverData = new ArrayList<String>();

		if(!this.ServerDataFile.exists()){
			try{
				this.ServerDataFile.createNewFile();
				this.serverData.add("UpdateChecker_True");
			}catch(IOException IOError){
				IOError.printStackTrace();		
			}
		}
	}
	public void loadData(){

		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.ServerDataFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null){
				if(!this.contains(line)){
					this.serverData.add(line);
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
			FileWriter stream = new FileWriter(this.ServerDataFile);
			BufferedWriter output = new BufferedWriter(stream);

			for (String value : this.serverData){	
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
		return this.serverData.contains(value);
	}

	public void add(String value){
		if (!this.contains(value)){
			this.serverData.add(value);
		}
	}

	public void remove(String value){
		this.serverData.remove(value);
	}

	public ArrayList<String> getValues(){
		return this.serverData;
	}
}
