/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Users getUsers()
    {
        return getListerApp().getUsers();
    }
    
    public User getUsersDetail(String email, String pass)
    {
       return getListerApp().getUsers().login(email, pass);
    }
    
}
