
package project.wsd.soap;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import project.wsd.ListerApplication;
import project.wsd.User;
import project.wsd.Users;

/**
 *
 * @author Anh Minh Tran
 */
@WebService(serviceName = "UserSOAP")
public class UserSOAP {
    @Resource
    private WebServiceContext context;
    
    // Getting Lister Application to access method for lister
    private ListerApplication getListerApp()
    {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            ListerApplication listerApp = (ListerApplication) application.getAttribute("listerApp");
            if (listerApp == null) {
                listerApp = new ListerApplication();
                listerApp.setFilePath(application.getRealPath("WEB-INF/User.xml"));
                application.setAttribute("listerApp", listerApp);
            }
            return listerApp;
        }
    }
    
    // Getting user object
    public Users getUsers()
    {
        return getListerApp().getUsers();
    }
    // Getting information of user details
    public User getUsersDetail(String email, String pass)
    {
       return getListerApp().getUsers().login(email, pass);
    }
    
}
