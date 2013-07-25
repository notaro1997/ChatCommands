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

public class BlockFile {

	public static ChatCommands plugin;
	public BlockFile(ChatCommands instance){
		plugin = instance;
	}

	public File BlockFile;
	public ArrayList<String> BlockedItems;

	public BlockFile(File file){
		this.BlockFile = file;
		this.BlockedItems = new ArrayList<String>();

		if(!this.BlockFile.exists()){
			try{
				this.BlockFile.createNewFile();
			}catch(IOException IOError){
				IOError.printStackTrace();		
			}
		}
	}
	public void loadData(){

		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.BlockFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null){
				if(!this.contains(line)){
					this.BlockedItems.add(line);
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
			FileWriter stream = new FileWriter(this.BlockFile);
			BufferedWriter output = new BufferedWriter(stream);

			for (String value : this.BlockedItems){	
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
		return this.BlockedItems.contains(value);
	}

	public void add(String value){
		if (!this.contains(value)){
			this.BlockedItems.add(value);
		}
	}

	public void remove(String value){
		this.BlockedItems.remove(value);
	}

	public ArrayList<String> getValues(){
		return this.BlockedItems;
	}
}
