
package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
	
	private File current = null;
	
	Controller(){
		this("output.txt");
	}
	
	Controller(String name){
		current = new File(System.getProperty("user.home") + File.separator + name);		
	}
	
	void SetFile(File f) {
        if (f.getParentFile().exists()) {
            current = f;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
	}
	
	File GetFile(){
		return current ;
	}
	
	String GetPath() {
		return current.getPath();
	}
	
	void PrintOnFile (String s) throws IOException{
		
		try (PrintStream out = new PrintStream(current, StandardCharsets.UTF_8)) {
            out.println(s);
        }
	}
}