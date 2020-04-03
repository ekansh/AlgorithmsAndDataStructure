package DateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dateStr= "13/03/2016";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date parse = sdf.parse(dateStr);
			System.out.println("StringToDate.main()"+parse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
