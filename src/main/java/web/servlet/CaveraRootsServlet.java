package web.servlet;

import cdi.ApplicationBean;
import cdi.RequestBean;
import cdi.SessionBean;
import model.Pessoa;
import servico.TesteServ;

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

    @Inject
    private TesteServ testeServ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Pessoa juvenas = testeServ.consultarPorId(1L);
        juvenas.setNome("Juvenas Juvenal Juvencio");
        testeServ.salvar(juvenas);

        /*
        Pessoa juvenas = new Pessoa();

        juvenas.setNome("Juvenas");
        juvenas.setIdade(36);
        juvenas.setDataNascimento(LocalDate.of(1981, 10, 11));
        juvenas.setDataCriacao(LocalDateTime.now());

        testeServ.salvar(juvenas);


        Pessoa asdrubal = new Pessoa();

        asdrubal.setNome("Asdrubal");
        asdrubal.setIdade(17);
        asdrubal.setDataNascimento(LocalDate.of(2002, 1, 1));
        asdrubal.setDataCriacao(LocalDateTime.now());

        testeServ.salvar(asdrubal);


        Pessoa tiburcio = new Pessoa();

        tiburcio.setNome("Tiburcio");
        tiburcio.setIdade(26);
        tiburcio.setDataNascimento(LocalDate.of(1991, 1, 1));
        tiburcio.setDataCriacao(LocalDateTime.now());

        testeServ.salvar(tiburcio);
        */



        applicationBean.hellow();
        sessionBean.hellow();
        requestBean.hellow();

        System.out.println("Application : " + ApplicationBean.contador);
        System.out.println("Session : " + SessionBean.contador);
        System.out.println("Request : " + RequestBean.contador);

    }


}
