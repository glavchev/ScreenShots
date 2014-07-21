/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenshotservice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
//import org.apache.http;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ByteArrayEntity;
//import org.apache.http.impl.client.HttpClients;
import sun.misc.Queue;
/**
 *
 * @author ncuxap
 */
public class FileSenderService {
    private static String serverData; // po natatak moje da se dobavqt o6te ne6ta, 
    //naprimer portove, direktorii i tn., zasega e samo adres
    private static Queue<Path> queue;
    
    public FileSenderService(String adress)
    {
        setServerParameters(adress);
    }
    public static void setServerParameters(String adr)
    {
        serverData = adr;
    }
    public static void setQueue(Queue<Path> q)
    {
        queue = q;
    }
    
    public static void sendFile() throws Exception
    {
        if(queue.isEmpty())
        {
            // TODO: better exceptions
            throw new Exception("Queue is empty");
        }
        
        Path file = queue.dequeue();
        byte[] fileContent = Files.readAllBytes(file);
        
        // actual file send
        // TODO
    }
    public static void sendFiles() throws Exception
    {
        while(!queue.isEmpty())
        {
            sendFile();
        }
    }
}
