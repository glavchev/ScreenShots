package screenshotservice;
 
import javax.xml.ws.Endpoint;
 
public class WebServiceClass{
 
    public static void main(String[] args) {
 
        Endpoint.publish("http://localhost:9898/HelloWeb", new WebClass());
 
        System.out.println("HelloWeb service is ready");
 
    }

}
 