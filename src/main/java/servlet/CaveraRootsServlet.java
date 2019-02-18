package servlet;

import cdi.ApplicationBean;
import cdi.RequestBean;
import cdi.SessionBean;
import model.Teste;
import servico.TesteServ;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/cavera/roots/")
public class CaveraRootsServlet extends HttpServlet {



    @Inject
    private ApplicationBean applicationBean;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private RequestBean requestBean;

    @Inject
    private TesteServ testeServ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        Teste teste = new Teste();

        teste.setNome("Daniel");
        teste.setIdade(36);
        teste.setDataNascimento(LocalDate.of(1981, 10, 11));
        teste.setDataCriacao(LocalDateTime.now());

        testeServ.salvar(teste);



        applicationBean.hellow();
        sessionBean.hellow();
        requestBean.hellow();

        System.out.println("Application : " + ApplicationBean.contador);
        System.out.println("Session : " + SessionBean.contador);
        System.out.println("Request : " + RequestBean.contador);

    }


}
