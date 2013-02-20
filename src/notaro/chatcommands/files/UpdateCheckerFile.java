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

public class UpdateCheckerFile {

	public static ChatCommands plugin;
	public UpdateCheckerFile(ChatCommands instance){
		plugin = instance;
	}

	public File UpdateCheckerFile;
	public ArrayList<String> UpdateTrueOrFalse;

	public UpdateCheckerFile(File file){
		this.UpdateCheckerFile = file;
		this.UpdateTrueOrFalse = new ArrayList<String>();

		if(!this.UpdateCheckerFile.exists()){
			try{
				this.UpdateCheckerFile.createNewFile();
				this.UpdateTrueOrFalse.add("True");
				saveData();
			}catch(IOException IOError){
				IOError.printStackTrace();		
			}
		}
	}
	public void loadData(){

		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.UpdateCheckerFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null){
				if(!this.contains(line)){
					this.UpdateTrueOrFalse.add(line);
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
			FileWriter stream = new FileWriter(this.UpdateCheckerFile);
			BufferedWriter output = new BufferedWriter(stream);

			for (String value : this.UpdateTrueOrFalse){	
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
		return this.UpdateTrueOrFalse.contains(value);
	}

	public void add(String value){
		if (!this.contains(value)){
			this.UpdateTrueOrFalse.add(value);
		}
	}

	public void remove(String value){
		this.UpdateTrueOrFalse.remove(value);
	}

	public ArrayList<String> getValues(){
		return this.UpdateTrueOrFalse;
	}
}
