package genericutility;

import java.time.LocalDateTime;
import java.util.Random;

import com.google.common.annotations.VisibleForTesting;
/**
 * This method is used to capture current system date and time
 * @return String
 */
public class JavaUtility {

	public String getSystemTime() {
    return LocalDateTime.now().toString().replace(":", "-");
		
	}
	
	/**
	 * This method is used to generate random numbers within 1000
	 * @return int
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}
}
