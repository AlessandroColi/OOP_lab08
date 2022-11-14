package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
	
	private File current = null;
	
	Controller(){
		this("output.txt");
	}
	
	Controller(String name){
		current = new File(System.getProperty("user.home") + System.getProperty("file.separator") + name);		
	}
	
	void SetFile(File f) {
		this.current = f ;
	}
	
	File GetFile(){
		return current ;
	}
	
	String GetPath() {
		return current.getPath();
	}
	
	void PrintOnFile (String s) throws IOException{
		
		Files.writeString(current.toPath(), s, StandardOpenOption.WRITE);
	}
}
