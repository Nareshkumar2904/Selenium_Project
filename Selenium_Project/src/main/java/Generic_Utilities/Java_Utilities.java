package Generic_Utilities;

import java.util.Date;

public class Java_Utilities {
	
	public static String getName() {
		String date = new Date().toString().replace(' ', '_').replace(':', '_');
		return date;
	}

}
