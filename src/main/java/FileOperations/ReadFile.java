package FileOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
	public void readFileContainingCharcterFromClassPath(){
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource("res/config.xml").toURI());
			BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			String line=null;
			while( (line=bufferedReader.readLine()) !=null){
				System.out.println(line);
				
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void readFileContainingCharcter(){
		try {
			Path path = Paths.get("input.xml");
			BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			String line=null;
			while( (line=bufferedReader.readLine()) !=null){
				System.out.println(line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	public static void main(String[] args) throws IOException {
		new ReadFile().readFileContainingCharcterFromClassPath();
		new ReadFile().readFileContainingCharcter();
	}
}
