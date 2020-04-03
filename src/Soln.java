import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Soln {
public static void main(String[] args) {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
		String readLine = reader.readLine();
		System.out.println(readLine);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
