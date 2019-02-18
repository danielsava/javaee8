package servico;

import model.Teste;
import repositorio.TesteDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

@ApplicationScoped
public class TesteServ implements Serializable {


    @Inject
    private TesteDao testeDao;

    @Transactional
    public void salvar(Teste teste) {
        testeDao.salvar(teste);
    }

}
