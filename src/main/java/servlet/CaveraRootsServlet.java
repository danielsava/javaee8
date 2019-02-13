package servlet;

import cdi.ApplicationBean;
import cdi.RequestBean;
import cdi.SessionBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cavera/roots/")
public class CaveraRootsServlet extends HttpServlet {



    @Inject
    private ApplicationBean applicationBean;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private RequestBean requestBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        applicationBean.hellow();
        sessionBean.hellow();
        requestBean.hellow();

        System.out.println("Application : " + ApplicationBean.contador);
        System.out.println("Session : " + SessionBean.contador);
        System.out.println("Request : " + RequestBean.contador);

    }


}
