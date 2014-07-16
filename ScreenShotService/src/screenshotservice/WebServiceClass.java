package screenshotservice;
 
import javax.xml.ws.Endpoint;
 
public class WebServiceClass{
 
    public static void Start() {
 
        Endpoint.publish("http://localhost:9898/HelloWeb", new WebClass());
 
        System.out.println("ScreenShot service is ready");
    }
    
        public static void Stop() {
            
             System.out.println("ScreenShot service stop work");
    }


}
 