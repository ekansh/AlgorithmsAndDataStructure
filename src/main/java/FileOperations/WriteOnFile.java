package FileOperations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteOnFile {

	public void writeOnFile() {
		String[] Lines = { "hello", "how", "are", "you","such as 会意字 / 會意字" };
		Path path = Paths.get("op.txt");
		BufferedWriter writer=null;
		try {
			writer = Files.newBufferedWriter(path, Charset.defaultCharset());
			for (String line : Lines) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writer !=null){
				try {
					writer.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new WriteOnFile().writeOnFile();
	}
}
