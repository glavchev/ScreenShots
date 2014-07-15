/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenshotservice;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author ncuxap
 */
public class ScreenShotService {

    /**
     * @param args the command line arguments
     */
    // TODO: make new thread for sending pictures to server maybe?
    
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        // TODO code application logic here
        String picturesPath = "D:" + File.separator + "test";
        
        //while(true)
        //{
            Date now = new Date();
            String nowString = now.toString().replace(':','_');
            
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] screens = ge.getScreenDevices();

            Rectangle allScreenBounds = new Rectangle();
            for (GraphicsDevice screen : screens) {
                Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();

                allScreenBounds.width += screenBounds.width;
                allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
            }

            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(allScreenBounds);
            
            String fileName = picturesPath + File.separator + nowString + ".png";
            
            File outputFile = new File(fileName);
            outputFile.createNewFile();
            
            ImageIO.write(screenShot, "png", outputFile);
            
            //Thread.sleep(300000); // 5 minutes in miliseconds
        //}
    }
    
    public static void stop()
    {
        // test
    }
}
