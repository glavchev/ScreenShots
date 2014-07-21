/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenshotservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import sun.misc.Queue;


public class DirectoryChecker {
    private static String ScreenShotDir;
    public static Queue<Path> filesToSend;
    public DirectoryChecker(String dir)
    {
        ScreenShotDir = dir;
    }
    
    private static void addDirFilesToQueue()
    {
        File pictureDir = getPictureDirObject(); // po podrazbirane papkata su6testvuva
        
        // ako ima failove, dobavqme gi v opashkata
        File[] files = pictureDir.listFiles();
        for(int i=0; i<files.length; ++i)
        {
            filesToSend.enqueue(files[i].toPath());
        }
    }
    public Queue<Path> getQueue()
    {
        return filesToSend;
    }
    private static File getPictureDirObject() // tva mai ne trq da e tuka
    {
        File pictureDir = new File(ScreenShotDir);
        pictureDir.mkdir();
        return pictureDir;
    }
    
    public static void checkPicturesDir() // will check for new files in directory and send them to server when possible
    {
        filesToSend = new Queue<Path>();
        addDirFilesToQueue();            
    }
}
