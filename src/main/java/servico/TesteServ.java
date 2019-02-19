package servico;

import model.Pessoa;
import repositorio.PessoaDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

@ApplicationScoped
public class TesteServ implements Serializable {


    @Inject
    private PessoaDao pessoaDao;

    @Transactional
    public void salvar(Pessoa pessoa) {
        pessoaDao.salvar(pessoa);
    }

    public Pessoa consultarPorId(Long id) {
        return pessoaDao.consultarPorId(id);
    }

}
