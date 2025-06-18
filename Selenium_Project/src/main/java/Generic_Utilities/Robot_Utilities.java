package Generic_Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Robot_Utilities {

	public static void robot() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A); // Select All
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_BACK_SPACE); // Clear
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

}
