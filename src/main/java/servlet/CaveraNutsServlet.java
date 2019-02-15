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

@WebServlet("/cavera/nuts/")
public class CaveraNutsServlet extends HttpServlet {


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

        resp.getWriter()
                .append("<html><body>")
                .append("<br/><br/>")
                .append("Application bean : ").append(String.valueOf(ApplicationBean.contador))
                .append("<br/><br/>")
                .append("Session bean : ").append(String.valueOf(SessionBean.contador))
                .append("<br/><br/>")
                .append("Request bean : ").append(String.valueOf(RequestBean.contador))
                .append("<br/>")
                .append("</body></html>");


    }


}
