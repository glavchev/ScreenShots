package screenshotservice;
 
import javax.jws.WebMethod;
 
import javax.jws.WebService;
 
@WebService
 
public class WebClass {
 
    @WebMethod
 
    public String sayGreeting(String name) {
 
        return "Greeting " + name + "!";
 
    }
 
}